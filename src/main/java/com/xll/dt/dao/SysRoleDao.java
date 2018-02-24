package com.xll.dt.dao;

import java.util.List;

import com.xll.dt.pojo.SysRole;

public interface SysRoleDao extends BaseDAO<SysRole>{

	List<String> selectRoleNameList(Long userId);

}
