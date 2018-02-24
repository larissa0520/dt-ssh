package com.xll.dt.controller;

import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.dt.pojo.SysUser;
import com.xll.dt.service.SysUserService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "sys/user/" + page;
	}

	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"sys:user:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params){
		
		//TODO 只有超级管理员，才能查看所有管理员列表
		/*if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}*/
		
		//查询列表数据
		Query query = new Query(params);
		return sysUserService.getPageList(query);
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions({"sys:user:delete"})
	public R deleteMore(@RequestBody Long[] ids){
		
		if(ArrayUtils.contains(ids, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		//这个shiro 获取的是tomcat的session
		Long userId =(Long)SecurityUtils.getSubject().getSession().getAttribute("userId");
		//TODO 系统管理员不能删除 当前用户不能删除
		if(ArrayUtils.contains(ids, userId)){
			System.out.println("当前用户不能删除");
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(ids);
		return R.ok();
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	@RequiresPermissions({"sys:user:save"})
	public R save(@RequestBody SysUser user){
		sysUserService.save(user);
		return R.ok();
	}
	
	@RequestMapping("/info/{userId}")
	@ResponseBody
	@RequiresPermissions({"sys:user:info"})
	public R info(@PathVariable Long userId){
		SysUser user = sysUserService.getById(userId);
		return R.ok().put("user", user);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions({"sys:user:update"})
	public R update(@RequestBody SysUser user){
		sysUserService.update(user);
		return R.ok();
	}
}
