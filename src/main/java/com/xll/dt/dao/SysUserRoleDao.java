package com.xll.dt.dao;


import java.io.Serializable;
import java.util.List;

import com.xll.dt.pojo.SysUserRole;


public interface SysUserRoleDao extends BaseDAO<SysUserRole>{
	Integer deleteByUserId(Serializable userId);

	Integer deleteByRoleIds(Serializable[] roleIds);

	Integer deleteByUserIds(Serializable[] userIds);

	List<Long> findRoleIdList(Long userId);
	
}
