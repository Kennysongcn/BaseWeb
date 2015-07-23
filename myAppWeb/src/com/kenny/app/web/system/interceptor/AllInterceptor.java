package com.kenny.app.web.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.provider.main.service.user.IUserService;
import com.kenny.app.web.system.util.Const;


public class AllInterceptor implements HandlerInterceptor {
	
	@Autowired
	private IUserService iUserService;
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView modelAndView) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// 判断路径是登出还是登录验证，是这两者之一的话执行Controller中定义的方法
		//获取路径
		String path = request.getServletPath();
		//不拦截的url
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}else{
			return true;
		}
	}
}