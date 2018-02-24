package com.xll.dt.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysRoleMenuDao;
import com.xll.dt.pojo.SysRoleMenu;

@Repository
public class SysRoleMenuDaoImpl extends BaseDAOImpl<SysRoleMenu> implements SysRoleMenuDao{
    
	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Value("SysRoleMenu")
	public void setClassName(String className) {
		super.className = className;
	}

	@Value("id")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}

	@Value("id")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
    
	
	@Override
	public Integer deleteByRoleId(Serializable roleId) {
		Query query = currentSession().createQuery("delete from SysRoleMenu where roleId = :roleId");
		query.setParameter("roleId", roleId);
		return query.executeUpdate();
	}

	@Override
	public Integer deleteByRoleIds(Serializable[] roleIds) {
		Query q = currentSession().createQuery(" delete from SysRoleMenu where roleId in (:roleIds)");  
		q.setParameterList("roleIds", roleIds);
		return q.executeUpdate();  
	}

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	@Override
	public List<Long> findMenuIdList(Long roleId) {
		String sql = "select menu_id from sys_role_menu where role_id = " + roleId;
		NativeQuery query = currentSession().createNativeQuery(sql);
		return query.list();
	}

	@Override
	public Integer deleteByMenuIds(Serializable[] menuIds) {
		Query q = currentSession().createQuery(
				" delete from SysRoleMenu where menuId in (:menuIds)");  
		q.setParameterList("menuIds", menuIds);
		return q.executeUpdate();  
	}
	
	//获得该用户拥有的权限的菜单
	@Override
	public List<Long> findMenuIdListByUserId(Long userId) {
		String sql = "select distinct rm.menu_id from sys_role_menu rm "
				+ " LEFT JOIN sys_user_role ur on ur.role_id = rm.role_id "
				+ " where ur.user_id = :userId";
		NativeQuery query = currentSession().createNativeQuery(sql);
		query.setParameter("userId", userId);
		return query.list();
	}


}
