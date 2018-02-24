package com.xll.dt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.annotation.MyLog;
import com.xll.dt.dao.SysRoleDao;
import com.xll.dt.dao.SysRoleMenuDao;
import com.xll.dt.dao.SysUserRoleDao;
import com.xll.dt.pojo.SysRole;
import com.xll.dt.pojo.SysRoleMenu;
import com.xll.dt.service.SysRoleService;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class SysRoleServiceImpl implements SysRoleService{
    

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
    @MyLog("显示角色")
	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<SysRole> rows = sysRoleDao.find(offset, limit);
		
		//调用Dao查询总记录数
		Long total = (Long)sysRoleDao.count();
				
		//创建DataGridResult对象
		DataGridResult result = new DataGridResult(total, rows);
		return result;
	}
    
    @MyLog("删除角色")
	@Override
	public void deleteBatch(Long[] ids) {
		sysRoleDao.deleteBatch(ids);
		sysRoleMenuDao.deleteByRoleIds(ids);
		sysUserRoleDao.deleteByRoleIds(ids);
	}
    
    @MyLog("获得角色")
	@Override
	public SysRole getById(Long roleId) {
		SysRole role = sysRoleDao.getById(roleId);
		
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuDao.findMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		
		return role;
	}
    
    @MyLog("保存角色")
	@Override
	public void save(SysRole role) {
		
		role.setCreateTime(new Date());
		sysRoleDao.save(role);
		
		//先删除角色与菜单关系
		Long roleId = role.getRoleId();
		sysRoleMenuDao.deleteByRoleId(roleId);
		
		List<Long> menuIdList = role.getMenuIdList();
		if(menuIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		for (int i = 0; i < menuIdList.size(); i++) {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setMenuId(menuIdList.get(i));
			sysRoleMenu.setRoleId(roleId);
			sysRoleMenuDao.save(sysRoleMenu);
		}
	}
    
    @MyLog("修改角色")
	@Override
	public void update(SysRole role) {
		
		sysRoleDao.update(role);
		
		//先删除角色与菜单关系
		Long roleId = role.getRoleId();
		sysRoleMenuDao.deleteByRoleId(roleId);
		
		List<Long> menuIdList = role.getMenuIdList();
		if(menuIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		for (int i = 0; i < menuIdList.size(); i++) {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setMenuId(menuIdList.get(i));
			sysRoleMenu.setRoleId(roleId);
			sysRoleMenuDao.save(sysRoleMenu);
		}
	}

	@Override
	public List<SysRole> findAll() {
		return sysRoleDao.findAll();
	}
	
	 @Override
     public List<String> selectRoleNameList(Long userId) {
	    return sysRoleDao.selectRoleNameList(userId);
	 }
}
