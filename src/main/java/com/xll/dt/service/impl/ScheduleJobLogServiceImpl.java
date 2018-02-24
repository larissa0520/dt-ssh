package com.xll.dt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.dao.ScheduleJobLogDao;
import com.xll.dt.pojo.ScheduleJobLog;
import com.xll.dt.service.ScheduleJobLogService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService{

	@Autowired
	private ScheduleJobLogDao scheduleJobLogDao;
	
	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<ScheduleJobLog> rows = scheduleJobLogDao.find(offset, limit);
		
		//调用Dao查询总记录数
		Long total = (Long)scheduleJobLogDao.count();
				
		//创建DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult(total, rows);
		return dataGridResult;
	}

	@Override
	public void deleteBatch(Long[] jobIds) {
		
		scheduleJobLogDao.deleteBatch(jobIds);
	}

	@Override
	public void save(ScheduleJobLog scheduleJobLog) {
		scheduleJobLogDao.save(scheduleJobLog);
	}

}
