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

import com.xll.dt.service.SysLogService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

/**
 * 系统任务
 * 
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "sys/log/" +  page;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"sys:log:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return sysLogService.getPageList(query);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions({"sys:log:delete"})
	public R deleteBatch(@RequestBody Long[] ids) {
		sysLogService.deleteBatch(ids);
		return R.ok();
	}
}
