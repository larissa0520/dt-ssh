package com.xll.dt.dao;

import java.util.List;

import com.xll.dt.pojo.SysMenu;

public interface SysMenuDao extends BaseDAO<SysMenu>{
	
    //type=0的菜单
	List<SysMenu> getNotButtonList();
	
	//获取user的权限
	List<String> getUserPermsList(Long userId);
	
    //获得父菜单为mull的menu(hql语法)
	List<SysMenu> getTopMenuList();
	
    //获得父菜单为mull的menu(sql语法)
	List<SysMenu> findAllTop();
	
	//获取所有父菜单根据父菜单id
	List<SysMenu> findByParentId(Long parentId);
	
	//获取一级菜单根根据id
	List<SysMenu> findUserTop(List<Long> ids);
	
	//获得菜单根据父菜单id和菜单id
	List<SysMenu> findUserMenuByParentId(Long parentId, List<Long> ids);
	
	

}
