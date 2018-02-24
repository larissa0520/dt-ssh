package com.xll.dt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.dao.SysLogDao;
import com.xll.dt.pojo.SysLog;
import com.xll.dt.service.SysLogService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<SysLog> rows = sysLogDao.find(offset, limit);
		
		//调用Dao查询总记录数
		Long total = (Long)sysLogDao.count();
				
		//创建DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult(total, rows);
		return dataGridResult;
	}

	@Override
	public void deleteBatch(Long[] jobIds) {
		
		sysLogDao.deleteBatch(jobIds);
	}

	@Override
	public void save(SysLog sysLog) {
		sysLogDao.save(sysLog);
	}

}
