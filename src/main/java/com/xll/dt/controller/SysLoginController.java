package com.xll.dt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.xll.dt.exception.RRException;
import com.xll.dt.service.SysUserService;
import com.xll.dt.util.PasswordUtil;
import com.xll.dt.vo.R;

@Controller
public class SysLoginController {

	/**自动注入Google的验证码生成器*/
	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
     
	//登陆
	@RequestMapping("/sys/login")
	@ResponseBody
	public R login(@RequestBody Map<String, String> userinfo) {
		
		//获取页面中输入的username 和 password
		String username = userinfo.get("username");
		String password = userinfo.get("password");
		String kaptcha = userinfo.get("kaptcha");
		String rememberMeStr = userinfo.get("rememberMe");
		
        
		//获取session中kaptcha
		Object kaptchaO = SecurityUtils.getSubject().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		if(kaptchaO == null) {
			throw new RRException("验证码失效");
			//return R.error("验证码失效");
		}

		SecurityUtils.getSubject().getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!kaptcha.equalsIgnoreCase(kaptchaO.toString())){
			return R.error("验证码不正确");
		}
	    
		System.out.println("rememberMeStr=" + rememberMeStr);
		Boolean rememberMe = false;
		if(rememberMeStr != null) {
			rememberMe = true;
		}
		
		try {
			// get the currently executing user: 获得subject
			// 从SecurityUtils里边创建一个subject
			Subject subject = SecurityUtils.getSubject();
			//验证时加密
			password = PasswordUtil.md5(password, username);
			//获得token
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			//为shiro的记住我赋值
			token.setRememberMe(rememberMe);
	
			System.out.println("rememberMe "+token.isRememberMe());
			//subject验证token
			subject.login(token);
		} catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		} catch (LockedAccountException e) {
			return R.error(e.getMessage());
		} catch (AuthenticationException e) {
			return R.error(e.getMessage());
		}
        
		SecurityUtils.getSubject().getSession().setAttribute("userId",sysUserService.getByUsername(username).getUserId());
		return R.ok();
	}

    
	//退出
    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect: login.html";
    }

	//生成验证码
	@RequestMapping("/kaptcha.jpg")
	@ResponseBody
	public void captcha(HttpServletResponse response) throws IOException {
		// 设置请求头 没有缓存
		response.setHeader("Cache-Control", "no-store,no-cache");
		// 设置内容
		response.setContentType("image.jpeg");

		// 生成文字
		String text = producer.createText();
		// 生成图片
		BufferedImage image = producer.createImage(text);

		// 将验证码保存到shiro的session中  Constants.KAPTCHA_SESSION_KEY这个键值是Google提供的  可以自己命名
		SecurityUtils.getSubject().getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
		//创建输出流
		ServletOutputStream out = response.getOutputStream();
		//生成图片
		ImageIO.write(image, "jpg", out);
		//刷新
		out.flush();
	}
}
