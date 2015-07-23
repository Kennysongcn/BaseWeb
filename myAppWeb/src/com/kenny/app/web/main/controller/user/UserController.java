package com.kenny.app.web.main.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenny.app.provider.main.model.user.User;
import com.kenny.app.provider.main.service.user.IUserService;
import com.kenny.app.web.main.controller.base.BaseController;



@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers",iUserService.findPagerAll());
		return "main/user/list";
	}
	
	
	//连接到ADD页面时 ，默认是get请求，会访问到一下代码
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user")User user, Model model){
		//开启modelDriven
		//model.addAttribute(new User());
		return "main/user/add";
	}
	//具体添加操作时候，使用POST请求，访问一下代码
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user){
		return "redirect:/main/user/list";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@Validated int id ,Model model){
		model.addAttribute(new User());
		return "main/user/update";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id ,Model model){
		model.addAttribute(iUserService.findOne(id));
		return "main/user/show";
	}
	
	
	
	@RequestMapping(value="/addCabinet",method=RequestMethod.GET)
	public String test(User user,Model model){
		model.addAttribute("orderNo",user.getUsername());
		model.addAttribute("stateCode",user.getPassword());
		return "main/user/cabinet";
	}
	
	

	
	/**
	 * 请求转发到登录jsp页面
	 * @return
	 */
	@RequestMapping(value = "/main/index")
	public String index(){
		return "main/index";
	}
	

}
