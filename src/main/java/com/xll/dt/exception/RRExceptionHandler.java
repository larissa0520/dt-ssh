package com.xll.dt.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xll.dt.vo.R;

/**
 * 全局异常
 */
//@ControllerAdvice
@Component
public class RRExceptionHandler implements HandlerExceptionResolver{
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
          Exception ex) {
      
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/json;charset=utf-8");
      
      
      try {
          R r = new R();
          
          if(ex instanceof RRException) {
              r.put("code", ((RRException)ex).getCode());
              r.put("msg", ((RRException)ex).getMessage());
          }else if(ex instanceof AuthorizationException) {
              
              R rForBootstrapTable = new R();
              rForBootstrapTable = R.error("权限不足，请联系管理员");
              
              r.put("rows", rForBootstrapTable);
              
          }else if(ex instanceof DuplicateKeyException) {
              r = R.error("记录已存在1");
          }else if(ex instanceof ConstraintViolationException) {
              r = R.error("记录已存在2");
          }else {
              r = R.error("未知错误，请联系管理员");
          }
          
          ex.printStackTrace();
          
          String json = JSON.toJSONString(r);
          response.getWriter().print(json);
          
      } catch (IOException e) {
          //throw
          e.printStackTrace();
      }
      
      return new ModelAndView();
  }
}