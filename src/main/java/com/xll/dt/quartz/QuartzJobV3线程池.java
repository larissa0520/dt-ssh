package com.xll.dt.quartz;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xll.dt.pojo.ScheduleJob;
import com.xll.dt.service.ScheduleJobLogService;
import com.xll.dt.util.SpringContextUtils;


public class QuartzJobV3线程池 extends QuartzJobBean {
    
	//不能使用主动注入   因为quartz是脱离spring容器的
	//线程池
	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("JOB_PARAM_KEY");
		Long jobId = scheduleJob.getJobId();
		
		
		try {

			long startTime = System.currentTimeMillis();

			System.out.println("准备执行任务，任务ID：" + jobId);

			// 创建task对象
			String beanName = scheduleJob.getBeanName();
			String methodName = scheduleJob.getMethodName();
			String params = scheduleJob.getParams();

			ScheduleRunnable task = new ScheduleRunnable(beanName, methodName, params);
			Future<?> future = executorService.submit(task);
			future.get();

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