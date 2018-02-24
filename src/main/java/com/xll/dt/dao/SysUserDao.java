package com.xll.dt.dao;


import com.xll.dt.pojo.SysUser;


public interface SysUserDao extends BaseDAO<SysUser>{

	SysUser getByUsername(String username);

	String getPasswordById(Long userId);
   
	
}
