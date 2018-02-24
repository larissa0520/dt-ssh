package com.xll.dt.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.dt.pojo.SysRole;
import com.xll.dt.service.SysRoleService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

@Controller
@RequestMapping("/sys/role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	/*@Autowired
	private SysRoleService sysRoleMenuService;
	@Autowired
	private SysRoleService sysUserRoleService;*/
	
	@RequestMapping("/{page}")
	public String listPage(@PathVariable String page){
		return "sys/role/"+page;
	}
	
	@ResponseBody
	@RequestMapping("list")
	@RequiresPermissions({"sys:role:list"})
	public DataGridResult list(@RequestParam Map<String, Object> params ) {
		//查询列表数据
		Query query = new Query(params);
		return sysRoleService.getPageList(query);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions({"sys:role:delete"})
	public R deleteMore(@RequestBody Long[] ids){
		sysRoleService.deleteBatch(ids);
		return R.ok();
	}
	
	@ResponseBody
	@RequestMapping("/info/{roleId}")
	@RequiresPermissions({"sys:role:info"})
	public R info(@PathVariable Long roleId){
		SysRole role = sysRoleService.getById(roleId);
		return R.ok().put("role", role);
	}
	
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions({"sys:role:save"})
	public R save(@RequestBody SysRole role){
		sysRoleService.save(role);
		return R.ok();
	}
	
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions({"sys:role:update"})
	public R update(@RequestBody SysRole role){
		sysRoleService.update(role);
		return R.ok();
	}
	
	/**
	 * 角色列表
	 */
	
	@RequestMapping("/select_all")
	@ResponseBody
	@RequiresPermissions({"sys:role:select"})
	public R select(){
		
		//如果不是超级管理员，则只查询自己所拥有的角色列表
		/*if(getUserId() != Constant.SUPER_ADMIN){
			map.put("createUserId", getUserId());
		}*/
		List<SysRole> roleList = sysRoleService.findAll();
		return R.ok().put("roleList", roleList);
	}
}
