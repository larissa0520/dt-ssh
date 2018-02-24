package com.xll.dt.service;

import com.xll.dt.pojo.ScheduleJobLog;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

public interface ScheduleJobLogService {

	//分页业务方法
	DataGridResult getPageList(Query query);

	void deleteBatch(Long[] ids);

	void save(ScheduleJobLog scheduleJobLog);
}
