package com.xll.dt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysRoleDao;
import com.xll.dt.pojo.SysRole;

@Repository
public  class SysRoleDaoImpl extends BaseDAOImpl<SysRole> implements SysRoleDao{
	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("SysRole")
	public void setClassName(String className) {
		super.className = className;
	}
	
	@Value("roleId")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}
	
	@Value("createTime")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
	
    @Override
    public List<String> selectRoleNameList(Long userId) {
        String sql = "SELECT r.role_name"
                    + " FROM sys_role r"
                    + " LEFT JOIN sys_user_role ur ON r.role_id = ur.role_id "
                    + " WHERE ur.user_id = :userId";
        NativeQuery sqlQuery = currentSession().createNativeQuery(sql);
        sqlQuery.setParameter("userId", userId);  
        return sqlQuery.list();
    }
}
