package com.xll.dt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.ScheduleJobLogDao;
import com.xll.dt.pojo.ScheduleJobLog;

@Repository
public class ScheduleJobLogDaoImpl extends BaseDAOImpl<ScheduleJobLog> implements ScheduleJobLogDao {
	
	@Autowired
	public void setSF(SessionFactory sf){
		//HibernateDaoSupport 为dao注入sessionFactory
	    super.setSessionFactory(sf);
	}
	
	@Value("ScheduleJobLog")
	public void setClassName(String className) {
		super.className = className;
	}
	
	@Value("logId")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}
	
	@Value("createTime")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}
	
	@Override
	public List<ScheduleJobLog> find( Integer start, Integer rows){
		String hql = "from ScheduleJobLog order by createTime desc";
		return super.find(hql, start, rows);
	}

}
