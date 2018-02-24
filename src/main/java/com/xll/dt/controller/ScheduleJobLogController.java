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

import com.xll.dt.service.ScheduleJobLogService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

/**
 * 定时任务
 * 
 */
@Controller
@RequestMapping("/schedule/joblog")
public class ScheduleJobLogController {

	@Autowired
	private ScheduleJobLogService scheduleJobLogService;
	
	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "schedule/joblog/" +  page;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"schedule:joblog:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return scheduleJobLogService.getPageList(query);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions({"schedule:joblog:delete"})
	public R deleteBatch(@RequestBody Long[] ids) {
		scheduleJobLogService.deleteBatch(ids);
		return R.ok();
	}
	
}
