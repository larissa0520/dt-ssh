package com.xll.dt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.ScheduleJobDao;
import com.xll.dt.pojo.ScheduleJob;



@Repository 
public class ScheduleJobDaoImpl extends BaseDAOImpl<ScheduleJob> implements ScheduleJobDao{
    //自动注入
	@Autowired
	public void setSF(SessionFactory sessionFactory) {
	   super.setSessionFactory(sessionFactory);
	}
	
	@Value("ScheduleJob")
	public void setClassName(String className) {
		super.className = className;
	}

	@Value("jobId")
	public void setKeyName(String keyName) {
		super.keyName = keyName;
	}

	@Value("jobId")
	public void setDefaultOrderColum(String defaultOrderColum) {
		super.defaultOrderColum = defaultOrderColum;
	}


}
