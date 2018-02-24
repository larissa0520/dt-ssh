package com.xll.dt.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.annotation.MyLog;
import com.xll.dt.dao.SysUserDao;
import com.xll.dt.dao.SysUserRoleDao;
import com.xll.dt.pojo.SysUser;
import com.xll.dt.pojo.SysUserRole;
import com.xll.dt.service.SysUserService;
import com.xll.dt.util.PasswordUtil;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class SysUserServiceImpl implements SysUserService{
    
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
    @MyLog("显示用户")
	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");

		//调用Dao查询分页列表数据
		List<SysUser> rows = sysUserDao.find(offset, limit);
		for (SysUser sysUser : rows) {
			sysUser.setPassword(null);
		}
		//调用Dao查询总记录数
		Long total = (Long)sysUserDao.count();

		//创建DataGridResult对象
	    DataGridResult dataGridResult = new DataGridResult(total, rows);
		return dataGridResult;
	}
	
    @MyLog("删除用户")
	@Override
	public void deleteBatch(Long[] userIds) {
		//在user表中删除记录
		sysUserDao.deleteBatch(userIds);
		//在关联表中也要删除记录
		sysUserRoleDao.deleteByUserIds(userIds);
	}
    
    @MyLog("保存用户")
	@Override
	public void save(SysUser user) {
		//创建者id
		//获得创建者
		SysUser creator = (SysUser)SecurityUtils.getSubject().getPrincipal();
		//设置创建者id
		user.setCreateUserId(creator.getUserId());
		
		//设置创建时间
		user.setCreateTime(new Date());
		
		//md5加密
		user.setPassword(PasswordUtil.md5(user.getPassword(), user.getUserName()));
		sysUserDao.save(user);
		
		//检查角色是否越权
		//checkRole(user);
		
		Long userId = user.getUserId();
		
		//获得页面上勾选的角色
		List<Long> roleIdList = user.getRoleIdList();
		if(roleIdList.size() == 0){
			return ;
		}
		
		//保存角色与菜单关系
		for (int i = 0; i < roleIdList.size(); i++) {
			//创建sysUserRole对象 存储user和role之间的关系
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(roleIdList.get(i));
			sysUserRole.setUserId(userId);
			sysUserRoleDao.save(sysUserRole);
		}
	}
    
    @MyLog("获得用户")
	@Override
	public SysUser getById(Long userId) {
		SysUser user = sysUserDao.getById(userId);
		user.setPassword(null);//不返回密码
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleDao.findRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return user;
	}
	
    @MyLog("修改用户")
	@Override
	public void update(SysUser user) {
		//获取数据库中的密码
		String password = sysUserDao.getPasswordById(user.getUserId());
		
		//如果用户没修改密码，则使用原来的密码
		if(StringUtils.isBlank(user.getPassword())){
		  user.setPassword(password);
		}else{
			user.setPassword(PasswordUtil.md5(user.getPassword(), user.getUserName()));
		}
		sysUserDao.update(user);
		
		//TODO 检查角色是否越权
		//checkRole(user);
		
		//先删除用户与角色的关系
		Long userId = user.getUserId();
		sysUserRoleDao.deleteByUserId(userId);
		
		List<Long> roleIdList = user.getRoleIdList();
		if(roleIdList.size() == 0){
			return ;
		}
		
		//保存角色与菜单关系
		for (int i = 0; i < roleIdList.size(); i++) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(roleIdList.get(i));
			sysUserRole.setUserId(userId);
			sysUserRoleDao.save(sysUserRole);
		}
		
	}
    
	//登录使用
	@Override
	public SysUser getByUsername(String username) {
		// TODO Auto-generated method stub
		return sysUserDao.getByUsername(username);
	}
	
	
}
