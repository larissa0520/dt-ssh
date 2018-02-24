package com.xll.dt.service;

import java.util.List;

import com.xll.dt.pojo.SysConfig;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

public interface SysConfigService {

	DataGridResult getPageList(Query query);

	void deleteBatch(Long[] ids);

	void save(SysConfig config);

	SysConfig getById(Long id);

	void update(SysConfig config);
    
	List<SysConfig> findByKeyPrefix(String keyPrefix);
}
