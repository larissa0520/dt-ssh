package com.xll.dt.quartz;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.pojo.ScheduleJobLog;
import com.xll.dt.service.ScheduleJobLogService;
import com.xll.dt.util.SpringContextUtils;

public class QuartzJobV4日志线程池 extends QuartzJobBean {

	// 不能使用主动注入 因为quartz是脱离spring容器的
	// 线程池
	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("JOB_PARAM_KEY");
		Long jobId = scheduleJob.getJobId();

		ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogServiceImpl");
        
		// 创建task对象
		String beanName = scheduleJob.getBeanName();
		String methodName = scheduleJob.getMethodName();
		String params = scheduleJob.getParams();

		//创建任务日志对象
		ScheduleJobLog log = new ScheduleJobLog();
		//设置属性
		log.setBeanName(beanName);
		log.setMethodName(methodName);
		log.setParams(params);
		log.setCreateTime(new Date());
		log.setJobId(jobId);
		
		//开始时间
		long startTime = System.currentTimeMillis();
		try {
			System.out.println("准备执行任务，任务ID：" + jobId);

			ScheduleRunnable task = new ScheduleRunnable(beanName, methodName, params);
			Future<?> future = executorService.submit(task);
			future.get();
			
			//总时长
		    long times = System.currentTimeMillis() - startTime;
            //设置时间
		    log.setTimes(times);
            log.setStatus((byte)0);
			
			System.out.println("任务执行完毕，任务ID：" + jobId + "，总耗时：" + times + "毫秒");

		} catch (Exception e) {
            e.printStackTrace();
            //总时长
            long times = System.currentTimeMillis() - startTime;
            //设置属性
            log.setTimes(times);
            log.setError(StringUtils.substring(e.toString(), 0, 2000));
            log.setStatus((byte)1);

		} finally {
			//保存任务记录
			scheduleJobLogService.save(log);
		}
	}
}