package com.kenny.app.web.system.interceptor.shiro;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.kenny.app.provider.main.model.user.User;
import com.kenny.app.provider.main.service.user.IUserService;

/**
 * @author kenny 2015-3-6
 */
public class MyRealm extends AuthorizingRealm {
	@Autowired
	private IUserService iUserService;

	/**
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * 
	 * @see 经测试:本例中该方法的调用时机为LoginController中执行Subject.login()时
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		/*
		 * 获取基于用户名和密码的令牌
		 * 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		 * 两个token的引用都是一样的
		 */
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("验证当前Subject时获取到token为"
				+ ReflectionToStringBuilder.toString(token,
						ToStringStyle.MULTI_LINE_STYLE));
		String username = token.getUsername();
		User user = iUserService.findByUsername(username);
		if (user != null) {
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					user.getUsername(), // 用户名
					user.getPassword(), // 密码
					getName() // realm name
			);
			this.setSession("currentUser", user);
			return authenticationInfo;
		} else {
			return null;
		}
	/*     if("mike".equals(token.getUsername())){  
	            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("mike", "mike", this.getName());  
	            this.setSession("currentUser", "mike");  
	            return authcInfo;  
	        }
	        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常  
	        return null; */
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * 
	 * @see 本例中该方法的调用时机为需授权资源被访问时
	 * @see 每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3
	 *      .1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		if (pc == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}
		// 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String currentUsername = (String) super.getAvailablePrincipal(pc);
		// String username = (String)pc.fromRealm(getName()).iterator().next();
		// 创建角色、资源list
	/**	List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		// 从数据库中获取当前登录用户的详细信息
		User user = iUserService.findByUsername(currentUsername);

		if (null != user) {
			// 实体类User中包含有用户角色的实体类信息
			if (null != user.getRoleIds() && user.getRoleIds().size() > 0) {
				// 获取当前登录用户的角色
				for (Role role : user.getRoleIds()) {
					roleList.add(role.getROLE_NAME());
					// 实体类Role中包含有角色权限的实体类信息
					if (null != role.getPermissions()
							&& role.getPermissions().size() > 0) {
						// 获取权限
						for (Permissions pmss : role.getPermissions()) {
							if (!StringUtil.isEmpty(pmss.getPermission())) {
								permissionList.add(pmss.getPermission());
							}
						}
					}
				}
			}
		} else {
			throw new AuthorizationException();
		}
		 //为当前用户设置角色和权限  
	      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
	      simpleAuthorInfo.addRoles(roleList);  
	      simpleAuthorInfo.addStringPermissions(permissionList);  
	      return simpleAuthorInfo;**/
	      
	      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
	        //实际中可能会像上面注释的那样从数据库取得  
	        if(null!=currentUsername && "admin".equals(currentUsername)){  
	            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色    
	            simpleAuthorInfo.addRole("admin");  
	            //添加权限  
	            simpleAuthorInfo.addStringPermission("admin:manage");  
	            System.out.println("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");  
	            return simpleAuthorInfo;  
	        }
	        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址  
	        //详见applicationContext.xml中的<bean id="shiroFilter">的配置  
	        return null; 
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	@SuppressWarnings("unused")
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out
					.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
