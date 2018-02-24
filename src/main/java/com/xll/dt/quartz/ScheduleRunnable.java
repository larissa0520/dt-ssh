package com.xll.dt.quartz;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import com.xll.dt.exception.RRException;
import com.xll.dt.util.SpringContextUtils;

public class ScheduleRunnable implements Runnable{
	 
    private Object target;
    private Method method;
    private String params;
	
    public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException{
    	 this.target = SpringContextUtils.getBean(beanName);
           
         this.params = params;
           
         if(StringUtils.isNotBlank(params)) {
               this.method = this.target.getClass().getDeclaredMethod(methodName, String.class);
         }else {
               this.method = this.target.getClass().getDeclaredMethod(methodName);
         }
    }
	@Override
	public void run() {
	  try {  
		 ReflectionUtils.makeAccessible(this.method);
           if(StringUtils.isNotBlank(this.params)) {
               this.method.invoke(this.target, this.params);
           }else {
               this.method.invoke(this.target);
           }
       } catch (Exception e) {
           throw new RRException("执行定时任务失败");
       }
	}

}
