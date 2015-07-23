package com.kenny.app.web.system.filter;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.kenny.app.provider.main.service.user.IUserService;
import com.kenny.app.web.system.util.Const;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author Administrator
 *
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private IUserService iUserService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Const.CURRENT_USER, iUserService.findByUsername(username));
        return true;
    }
}