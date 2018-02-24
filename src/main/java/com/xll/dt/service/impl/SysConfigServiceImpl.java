package com.xll.dt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.dao.SysConfigDao;
import com.xll.dt.pojo.SysConfig;
import com.xll.dt.service.SysConfigService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;

	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<SysConfig> rows = sysConfigDao.find(offset, limit);
		
		//调用Dao查询总记录数
		Long total = (Long)sysConfigDao.count();
		
		//创建DataGridResult对象
		DataGridResult result = new DataGridResult(total, rows);
		return result;	
	}

	@Override
	public void deleteBatch(Long[] ids) {
		sysConfigDao.deleteBatch(ids);
	}

	@Override
	public void save(SysConfig config) {
		sysConfigDao.save(config);
	}

	@Override
	public SysConfig getById(Long id) {
		return sysConfigDao.getById(id);
	}

	@Override
	public void update(SysConfig config) {
		sysConfigDao.update(config);
	}

	@Override
	public List<SysConfig> findByKeyPrefix(String keyPrefix) {
		return sysConfigDao.findByKeyPrefix(keyPrefix);
	}

}
