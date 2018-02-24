package com.xll.dt.service.impl;

import java.util.Date;
import java.util.List;


import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.dao.ScheduleJobDao;
import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.quartz.ScheduleUtilsV1;
import com.xll.dt.service.ScheduleJobService;
import com.xll.dt.util.Constant;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService{
   
	//自动注入
	@Autowired
	private ScheduleJobDao scheduleJobDao;
    
	@Autowired
	private Scheduler scheduler;
	
   //分页列表
	@Override
	public DataGridResult getPageList(Query query) {
		Integer offset = (Integer)query.get("offset");
		Integer limit = (Integer)query.get("limit");
		
		//调用Dao查询分页列表数据
		List<ScheduleJob> rows = scheduleJobDao.find(offset, limit);
		
		//调用Dao查询总记录数
		Long total = (Long)scheduleJobDao.count();
				
		//创建DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult(total, rows);
		return dataGridResult;
	}



    //批量删除
	@Override
    public void deleteBatch(Long[] jobIds) {
        //删除任务
        for(Long jobId : jobIds){
            ScheduleUtilsV1.deleteJob(scheduler, jobId);
        }
        scheduleJobDao.deleteBatch(jobIds);
    }

    //保存
	@Override
	public void save(ScheduleJob scheduleJob) {
		//设置创建时间
		scheduleJob.setCreateTime(new Date());
		//设置状态
		scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
		scheduleJobDao.save(scheduleJob);
		
	    //创建任务
        ScheduleUtilsV1.createJob(scheduler, scheduleJob);
	}


    //根据id获得schedule
	@Override
	public ScheduleJob getById(Long jobId) {
		return scheduleJobDao.getById(jobId);
	}


    //更新
	 @Override
	 public void update(ScheduleJob scheduleJob) {   
	        ScheduleUtilsV1.updateJob(scheduler, scheduleJob);
	        scheduleJobDao.update(scheduleJob);
    }
	
	
	@Override
    public void pauseBatch(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtilsV1.pauseJob(scheduler, jobIds[0]);
        }
        
        for (Long jobId : jobIds) {
            ScheduleJob job = scheduleJobDao.getById(jobId);
            job.setStatus(Constant.ScheduleStatus.PAUSE.getValue());
            scheduleJobDao.update(job);
        }
    }



	@Override
	public void resumeBatch(Long[] jobIds) {
		for(Long jobId : jobIds){
		  ScheduleUtilsV1.resumeJob(scheduler, jobIds[0]);
	    }
	
	   for (Long jobId : jobIds) {
		  ScheduleJob job = scheduleJobDao.getById(jobId);
		  job.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
		  scheduleJobDao.update(job);
	  }
	}



	 @Override
	    public void runBatch(Long[] jobIds) {
	        for(Long jobId : jobIds){
	            ScheduleUtilsV1.run(scheduler, jobId);
	        }
	    }
	
}
