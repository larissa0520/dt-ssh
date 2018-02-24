package com.xll.dt.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysMenuDao;
import com.xll.dt.pojo.SysMenu;


@Repository
public class SysMenuDaoImpl extends BaseDAOImpl<SysMenu> implements SysMenuDao {
	
	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("SysMenu")
	public void setClassName(String className) {
		super.className = className;
	}
	
	@Value("menuId")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}
	
	@Value("orderNum")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
    
	//type=0的菜单
	@Override
	public List<SysMenu> getNotButtonList() {
		return find("from SysMenu where type = 0 order by orderNum asc ");
	}
	
	//获取user的权限
	@Override
	public List<String> getUserPermsList(Long userId) {
		
		String sql = " SELECT m.perms"

					+ " FROM sys_menu m"
					
					+ " LEFT JOIN sys_role_menu rm"
					+ " ON m.menu_id = rm.menu_id"
					
					+ " LEFT JOIN sys_user_role ur"
					+ " ON ur.role_id = rm.role_id"
					
					+ " WHERE ur.user_id = :userId";
		
		NativeQuery sqlQuery = currentSession().createNativeQuery(sql);
		sqlQuery.setParameter("userId", userId);  
		return sqlQuery.list();
		//return nativeFind(sql, new Object[] {userId});
	}
    
	//所有的一级菜单
	@Override
	public List<SysMenu> getTopMenuList() {
		return find("from SysMenu where parentMenu.menuId = null order by orderNum asc ");
	}
	
	//所有的一级菜单
	@Override
	public List<SysMenu> findAllTop() {
		String sql = "select * from sys_menu where parent_id is null order by order_num";
		NativeQuery<SysMenu> query = currentSession().createNativeQuery(sql, SysMenu.class);
		return query.list();
	}
	
	//获取所有父菜单根据父菜单id
	@Override
	public List<SysMenu> findByParentId(Long parentId) {
		String sql = "select * from sys_menu where parent_id = :parentId order by order_num";
		NativeQuery<SysMenu> query = currentSession().createNativeQuery(sql, SysMenu.class);
		query.setParameter("parentId", parentId);
		return query.list();
	}
	
	//获取一级菜单根根据id
	@Override
	public List<SysMenu> findUserTop(List<Long> ids) {
		String sql = "select * from sys_menu where parent_id is null and menu_id in (:ids) order by order_num";
		NativeQuery<SysMenu> query = currentSession().createNativeQuery(sql, SysMenu.class);
		query.setParameter("ids", ids);
		return query.list();
	}
	
	//获得菜单根据父菜单id和菜单id
	@Override
	public List<SysMenu> findUserMenuByParentId(Long parentId, List<Long> ids) {
		String sql = "select * from sys_menu where parent_id = :parentId and menu_id in (:ids) order by order_num";
		NativeQuery<SysMenu> query = currentSession().createNativeQuery(sql, SysMenu.class);
		query.setParameter("parentId", parentId);
		query.setParameter("ids", ids);
		return query.list();
	}

}
