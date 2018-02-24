package com.xll.dt.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.xll.dt.annotation.MyLog;
import com.xll.dt.pojo.SysLog;
import com.xll.dt.service.SysLogService;
import com.xll.dt.util.HttpContextUtils;
import com.xll.dt.util.IPUtils;
import com.xll.dt.util.ShiroUtils;

public class SysLogAspect {
	@Autowired
    private SysLogService sysLogService;
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。");
        
        SysLog log = new SysLog();
        
        //解析织入点
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        
        //读取目标方法上的注解
        MyLog mylog = method.getAnnotation(MyLog.class);
        if(mylog != null) {
            String value = mylog.value();
            System.out.println(value);
            log.setOperation(value);
        }
        
        //请求方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        
        //获取请求参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args);
        log.setParams(params);
        
        //请求地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setIp(IPUtils.getIpAddr(request));
        
        //请求时间
        log.setCreateDate(new Date());
        
        //请求用户名
        log.setUsername(ShiroUtils.getUser().getUserName());
        
        
        //生成系统日志
        sysLogService.save(log);
    }
}
