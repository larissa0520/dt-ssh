package com.xll.dt.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.dt.pojo.SysConfig;
import com.xll.dt.service.SysConfigService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

/**
 * 定时任务
 * 
 */
@Controller
@RequestMapping("/sys/config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "sys/config/" +  page;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"sys:config:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return sysConfigService.getPageList(query);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions({"sys:config:delete"})
	public R deleteBatch(@RequestBody Long[] ids) {
		sysConfigService.deleteBatch(ids);
		return R.ok();
	}
	
	@RequestMapping("/save")
	@ResponseBody
	@RequiresPermissions({"sys:config:save"})
	public R save(@RequestBody SysConfig sysConfig) {
		sysConfigService.save(sysConfig);
		return R.ok();
	}
	
	@RequestMapping("/info/{id}")
	@ResponseBody
	@RequiresPermissions({"sys:config:info"})
	public R save(@PathVariable Long id) {
		SysConfig sysConfig = sysConfigService.getById(id);
		return R.ok().put("config", sysConfig);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions({"sys:config:update"})
	public R update(@RequestBody SysConfig sysConfig) {
		sysConfigService.update(sysConfig);
		return R.ok();
	}
	
}
