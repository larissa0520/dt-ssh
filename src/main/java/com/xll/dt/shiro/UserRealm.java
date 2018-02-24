package com.xll.dt.shiro;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.xll.dt.pojo.SysUser;
import com.xll.dt.service.SysMenuService;
import com.xll.dt.service.SysRoleService;
import com.xll.dt.service.SysUserService;
import com.xll.dt.util.ShiroUtils;

public class UserRealm extends AuthorizingRealm{
    
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysRoleService sysRoleService;
	
	/**认证*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//用户输入的用户名或密码
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		
		//查询数据库中用户信息
		SysUser user = sysUserService.getByUsername(username);
		
		if(user == null) {
			System.out.println("账户不存在");
			throw new UnknownAccountException("账户不存在");
		}
		
		/*if(!password.equals(user.getPassword())) {
			System.out.println("密码不正确");
			throw new IncorrectCredentialsException("密码不正确");
		}*/
		
		if (user.getStatus() == 0) {
			System.out.println("账户已被锁定,请联系管理员");
			throw new LockedAccountException("账户已被锁定,请联系管理员");
		}
		
		 //显示登陆用户的角色信息
	     List<String> roleList = sysRoleService.selectRoleNameList(user.getUserId());
	     ShiroUtils.setSessionAttribute("roles", roleList);
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, this.getName());
		return info;
	}
	
	/**授权*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权中.....");
		
		//获得用户
		SysUser user = (SysUser)principals.getPrimaryPrincipal();
		//获得userid 查询授权的时候使用
		Long userId = user.getUserId();
	
		//用户角色列表
		List<String> roleList = Arrays.asList("larissa","admin");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//分配角色权限
		info.addRoles(roleList);
		
		//查询该登陆用户的资源权限
		List<String> permissions = sysMenuService.getUserPermsList(userId);
		//Arrays.asList("sys:role:list","sys:role:info");
		for (String perm : permissions) {
			System.out.println(perm);
		}
		//分配资源权限
		info.addStringPermissions(permissions);
		
		return info;
	}

}
