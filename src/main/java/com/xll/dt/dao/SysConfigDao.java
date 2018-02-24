package com.xll.dt.dao;

import java.util.List;

import com.xll.dt.pojo.SysConfig;

public interface SysConfigDao extends BaseDAO<SysConfig>{
	List<SysConfig> findByKeyPrefix(String keyPrefix);
}
