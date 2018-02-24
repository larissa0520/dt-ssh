package com.xll.dt.quartz;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.ReflectionUtils;

import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.quartz.task.TestTask;
import com.xll.dt.util.SpringContextUtils;

public class QuartzJobV2反射 extends QuartzJobBean{
	 @Override
	    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	        
	        ScheduleJob scheduleJob = (ScheduleJob)context.getMergedJobDataMap().get("JOB_PARAM_KEY");
	        Long jobId = scheduleJob.getJobId();
	        
	        System.out.println("job:" + jobId);
	        
	        try {
	            
	            long startTime = System.currentTimeMillis();
	            
	            System.out.println("准备执行任务，任务ID：" + jobId);
	            
	            //创建task对象
	            String beanName = scheduleJob.getBeanName();
	            String methodName = scheduleJob.getMethodName();
	            String params = scheduleJob.getParams();
	            
	            Object target = SpringContextUtils.getBean(beanName);
	            System.out.println("target=" + target.getClass().getName());
	            
	            Method method = null;
	            if(StringUtils.isNotBlank(params)) {
	                method = target.getClass().getDeclaredMethod(methodName, String.class);
	            }else {
	                method = target.getClass().getDeclaredMethod(methodName);
	            }
	            
	            ReflectionUtils.makeAccessible(method);
	            if(StringUtils.isNotBlank(params)) {
	                method.invoke(target, params);
	            }else {
	                method.invoke(target);
	            }
	            
	            long times = System.currentTimeMillis() - startTime;
	            
	            System.out.println("任务执行完毕，任务ID：" + jobId + "，总耗时：" + times + "毫秒");
	            
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            
	            System.out.println("任务执行失败，任务ID：" + jobId);
	            
	        } finally {
	            
	            System.out.println("日志的保存");
	        }
	    }
	}