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

import com.xll.dt.pojo.SysRole;
import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.service.ScheduleJobService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

@Controller
@RequestMapping("/schedule/job")
public class ScheduleJobController {
   
	/**自动注入*/
	@Autowired
	private ScheduleJobService scheduleJobService; 
	
	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "schedule/job/" +  page;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions({"schedule:job:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return scheduleJobService.getPageList(query);
	}
	
	
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions({"schedule:job:delete"})
	public R deleteMore(@RequestBody Long[] ids){
		scheduleJobService.deleteBatch(ids);
		return R.ok();
	}
	
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions({"schedule:job:save"})
	public R save(@RequestBody ScheduleJob schedule){
		scheduleJobService.save(schedule);
		return R.ok();
	}
	
	@ResponseBody
	@RequestMapping("/info/{jobId}")
	@RequiresPermissions({"schedule:job:info"})
	public R info(@PathVariable Long jobId){
		ScheduleJob schedule = scheduleJobService.getById(jobId);
		return R.ok().put("schedule",schedule);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions({"schedule:job:update"})
	public R update(@RequestBody ScheduleJob schedule){
		scheduleJobService.update(schedule);
		return R.ok();
	}
	
	
	@RequestMapping("/pause")
	@ResponseBody
	@RequiresPermissions({"schedule:job:pause"})
	public R pauseBatch(@RequestBody Long[] ids) {
		scheduleJobService.pauseBatch(ids);
		return R.ok();
	}
	
	@RequestMapping("/resume")
	@ResponseBody
	@RequiresPermissions({"schedule:job:resume"})
	public R resumeBatch(@RequestBody Long[] ids) {
		scheduleJobService.resumeBatch(ids);
		return R.ok();
	}
	

	@RequestMapping("/run")
	@ResponseBody
	@RequiresPermissions({"schedule:job:run"})
	public R runBatch(@RequestBody Long[] ids) {
		scheduleJobService.runBatch(ids);
		return R.ok();
	}
}
