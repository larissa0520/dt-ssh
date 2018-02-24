package com.xll.dt.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysUserRoleDao;
import com.xll.dt.pojo.SysUserRole;

@Repository
public class SysUserRoleDaoImpl extends BaseDAOImpl<SysUserRole> implements SysUserRoleDao {
	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("SysUserRole")
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
	public Integer deleteByUserId(Serializable userId) {
		Query q = currentSession().createQuery(
				" delete from SysUserRole where userId = :roleId");  
		q.setParameter("roleId", userId);
		return q.executeUpdate();  
	}
	
	//批量删除  在role页面中删除role时  需要删除相应的和该角色有关的多对多关系
	@Override
	public Integer deleteByRoleIds(Serializable[] roleIds) {
		Query q = currentSession().createQuery(
				" delete from SysUserRole where roleId in (:roleIds)");  
		q.setParameterList("roleIds", roleIds);
		return q.executeUpdate();  
	}
   
	//批量删除 在user页面中删除user时 需要删除相应的和user相关的多对多关系
	@Override
	public Integer deleteByUserIds(Serializable[] userIds) {
		Query q = currentSession().createQuery(
				" delete from SysUserRole where userId in (:userIds)");  
		q.setParameterList("userIds", userIds);
		return q.executeUpdate();  
	}
    
	//修改user时  角色的回显(获得属于该user所拥有的role)
	@Override
	public List<Long> findRoleIdList(Long userId) {
		/*String sql = "select role_id from sys_user_role where user_id = :userId";
		NativeQuery query = currentSession().createNativeQuery(sql);
		query.setParameter("userId", userId);
		return query.list();*/
		
		Query q = currentSession().createQuery("select roleId from SysUserRole where userId = :userId");  
		q.setParameter("userId", userId);
		return q.list();
	}
	


}
