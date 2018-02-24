package com.xll.dt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysLogDao;
import com.xll.dt.pojo.SysLog;

@Repository
public class SysLogDaoImpl extends BaseDAOImpl<SysLog> implements SysLogDao {
	
	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("SysLog")
	public void setClassName(String className) {
		super.className = className;
	}
	
	@Value("id")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}
	
	@Value("createDate")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
	
	@Override
	public List<SysLog> find( Integer start, Integer rows){
		String hql = "from SysLog order by createDate desc";
		return super.find(hql, start, rows);
	}
}
