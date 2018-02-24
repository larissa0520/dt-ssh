package com.xll.dt.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.annotation.MyLog;
import com.xll.dt.dao.SysMenuDao;
import com.xll.dt.dao.SysRoleMenuDao;
import com.xll.dt.pojo.SysMenu;
import com.xll.dt.service.SysMenuService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class SysMenuServiceImpl implements SysMenuService{

	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
    
	@MyLog("显示菜单")
	@Override
	public DataGridResult getPageList(Query query) {
		
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<SysMenu> rows = sysMenuDao.find(offset, limit);
		//调用Dao查询总记录数
		Long total = (Long)sysMenuDao.count();
				
		//创建DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult(total, rows);
		return dataGridResult;
	}
    
	@MyLog("删除菜单")
	@Override
	public void deleteBatch(Long[] menuIds) {
		sysMenuDao.deleteBatch(menuIds);
		sysRoleMenuDao.deleteByMenuIds(menuIds);
	}
    
	@MyLog("获得菜单")
	@Override
	public SysMenu getById(Long menuId) {
		return sysMenuDao.getById(menuId);
	}
    
	@MyLog("保存菜单")
	@Override
	public void save(SysMenu menu) {
		if(menu.getParentMenu() != null && menu.getParentMenu().getMenuId() == null ) {
			menu.setParentMenu(null);
		}
		sysMenuDao.save(menu);
	}
	
	@MyLog("修改菜单")
	@Override
	public void update(SysMenu menu) {
		sysMenuDao.update(menu);
	}
    
	//type=0的菜单
	@Override
	public List<SysMenu> getNotButtonList() {
		return sysMenuDao.getNotButtonList();
	}
    
	
	
	@Override
	public List<SysMenu> findAll() {
		return sysMenuDao.findAll();
	}
    
	//获得user的 授权资源
	@Override
	public List<String> getUserPermsList(Long userId) {
		List<String> userPermsList = sysMenuDao.getUserPermsList(userId);
		
		List<String> finalPermsList = new ArrayList<String>();
		for (int i = 0; i < userPermsList.size(); i++) {
			String perms = userPermsList.get(i);
			if(StringUtils.isBlank(perms)) {
				continue;
			}
			finalPermsList.addAll(Arrays.asList(perms.split(",")));
		}
		
		return finalPermsList;
	}
    
	//获得user的 授权资源
	@Override
	public List<SysMenu> getTopMenuList() {
		return sysMenuDao.getTopMenuList();
	}
    
	//获得菜单
	@Override
	public List<SysMenu> findUserMenuList(Long userId) {
		
		List<SysMenu> menuList = new ArrayList<SysMenu>();
		//系统管理员，拥有最高权限
		if(userId == 1){
			//获得所有的一级菜单
			menuList = sysMenuDao.findAllTop();
			//为一级菜单的孩字菜单赋值
			for (int i = 0; i < menuList.size(); i++) {
				List<SysMenu> subMenu = sysMenuDao.findByParentId(menuList.get(i).getMenuId());
				menuList.get(i).setChildren(subMenu);
			}
			return menuList;
		}
		
		//用户菜单列表
		List<Long> menuIdList = sysRoleMenuDao.findMenuIdListByUserId(userId);
		
		menuList = sysMenuDao.findUserTop(menuIdList);
		for (int i = 0; i < menuList.size(); i++) {
			List<SysMenu> subMenu = sysMenuDao.findUserMenuByParentId(menuList.get(i).getMenuId(), menuIdList);
			menuList.get(i).setChildren(subMenu);
		}
		return menuList;
	}
}

