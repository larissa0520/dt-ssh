package com.xll.dt.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysUserDao;
import com.xll.dt.pojo.SysUser;

@Repository
public class SysUserDaoImpl extends BaseDAOImpl<SysUser> implements SysUserDao {


	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("SysUser")
	@Override
	public void setClassName(String className) {
		super.className = className;
	}
	
	@Value("userId")
	@Override
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}
	
	@Value("createTime")
	@Override
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
    
	//修改时 关于是否修改密码需要使用的
	@Override
	public String getPasswordById(Long userId) {
		return (String)this.uniqueResult("select password from SysUser where userId = ?", new Object[]{userId});
	}
    
	//登录使用
	@Override
	public SysUser getByUsername(String username) {
		return this.get("from SysUser where username = ?", new Object[] {username});
	}

}
