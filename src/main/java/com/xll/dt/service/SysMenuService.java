package com.xll.dt.service;


import java.util.List;

import com.xll.dt.pojo.SysMenu;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;


public interface SysMenuService {

	DataGridResult getPageList(Query query);

	void deleteBatch(Long[] ids);
	//type=0的菜单
	List<SysMenu> getNotButtonList();

	void save(SysMenu menu);

	SysMenu getById(Long menuId);
	
	void update(SysMenu menu);
    
	List<SysMenu> findAll();
	
    //获得user的 授权资源
	List<String> getUserPermsList(Long userId);
	
	//获取一级菜单根根据id
	List<SysMenu> getTopMenuList();
	
    //获得菜单
	List<SysMenu> findUserMenuList(Long userId);
}
