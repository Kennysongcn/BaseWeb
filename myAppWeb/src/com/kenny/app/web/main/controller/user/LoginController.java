package com.kenny.app.web.main.controller.user;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenny.app.provider.main.model.user.User;
import com.kenny.app.provider.main.service.user.IUserService;
import com.kenny.app.web.main.controller.base.BaseController;

@Controller
public class LoginController extends BaseController {
	@Autowired
	private IUserService iUserService;


    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String login( Model model){
    	model.addAttribute(new User());
    	return "login/login";
    }
    
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String showLoginForm(@ModelAttribute User user, Model model) {
    	String url="";
		String username=user.getUsername();
		String password=user.getPassword();
		 UsernamePasswordToken token = new UsernamePasswordToken(username,password);
	        Subject subject = SecurityUtils.getSubject();
	       
		 try {
			 subject.login(token);
		    } catch(UnknownAccountException unAccount){
		    	unAccount.printStackTrace();
		    	url="redirect:/404.jsp";
		    	return url;
		    }
		 catch (Exception e) {
		      e.printStackTrace();
		    }
		 	url="redirect:/main/system/index";
		    return url;
    }

    @RequestMapping(value = "/main/system/index",method= RequestMethod.GET)
    public String test(@ModelAttribute User user, Model model) {
    	 Subject subject = SecurityUtils.getSubject();
    	 if(subject.hasRole("admin")){
    		 return "main/system/index";
    	 }else{
    		 return "redirect:/unauthorizedUrl.jsp";
    	 }
    }
}
