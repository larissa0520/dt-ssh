package com.xll.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.xll.dt.pojo.SysRoleMenu;

public interface SysRoleMenuDao extends BaseDAO<SysRoleMenu> {
	Integer deleteByRoleId(Serializable roleId);

	Integer deleteByMenuIds(Serializable[] menuIds);

	Integer deleteByRoleIds(Serializable[] roleIds);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> findMenuIdList(Long roleId);
    
	//获得该用户拥有的权限的菜单
	List<Long> findMenuIdListByUserId(Long userId);
}
