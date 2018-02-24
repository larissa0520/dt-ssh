package com.xll.dt.service;

import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

public interface ScheduleJobService {

	DataGridResult getPageList(Query query);

	void deleteBatch(Long[] ids);

	void save(ScheduleJob schedule);

	ScheduleJob getById(Long jobId);

	void update(ScheduleJob schedule);

	void pauseBatch(Long[] jobIds);

	void resumeBatch(Long[] ids);

	void runBatch(Long[] ids);

}
