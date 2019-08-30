package cn.app.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.entity.BackendUser;
import cn.app.entity.DevUser;
import cn.app.service.BackendUserService;
import cn.app.service.DevUserService;

/**
 * 不拦截的请求
 * @author lenovo
 *
 */
@Controller
public class LoginController {
	private Logger log=Logger.getLogger(LoginController.class);
	@Resource
	private BackendUserService backendUserService;
	@Resource
	private DevUserService devUserService;
	/**
	 * 
	 */
	@RequestMapping(value="")
	public String gate(){
		log.info("正在跳转至入口界面..");
		return "gate";
	}
	
	/**
	 * 跳转至开发者平台登录页面
	 */
	@RequestMapping(value="/dev_user/login")
	public String devLogin(){
		log.info("正在跳转至开发者平台登录界面..");
		return "dev_user/login";
	}
	
	/**
	 * 登录检查开发者用户名和密码
	 */
	@RequestMapping(value="/dev_user/loginCheck",method = RequestMethod.POST)
	public String devLoginCheck(Model model,@RequestParam String name,
			@RequestParam String password,HttpSession session){
		log.info("正在检查用户名为"+name+"密码为"+password+"的开发者用户...");
		List<DevUser> devUserList=devUserService.getDevUserList();
		for(DevUser devUser1:devUserList){
			if(devUser1.getDevCode().equals(name)&&devUser1.getDevPassword().equals(password)){
				model.addAttribute("presentCust", devUser1);
				session.setAttribute("presentCust", devUser1);
				log.info("登陆成功！");
				log.info("正在跳转至开发者平台首页页面..");
				return "dev_user/index";
			}
		}
		log.info("登陆失败！请检查开发者用户名和密码！");
		return "dev_user/login";
	}
	
	/**
	 * 跳转至后台管理用户平台登录页面
	 */
	@RequestMapping(value="/backend_user/login")
	public String login(){
		log.info("正在跳转至后台管理系统登录界面..");
		return "backend_user/login";
	}
	
	/**
	 * 登录检查后台管理用户名和密码
	 */
	@RequestMapping(value="/backend_user/loginCheck",method = RequestMethod.POST)
	public String loginCheck(Model model,@RequestParam String name,
			@RequestParam String password,HttpSession session){
		log.info("正在检查用户名为"+name+"密码为"+password+"的后台管理用户...");
		List<BackendUser> backendUserList=backendUserService.getBackendUserList();
		for(BackendUser backendUser1:backendUserList){
			if(backendUser1.getUserCode().equals(name)&&backendUser1.getUserPassword().equals(password)){
				model.addAttribute("presentCust", backendUser1);
				session.setAttribute("presentCust", backendUser1);
				log.info("登陆成功！");
				log.info("正在跳转至后台管理系统首页页面..");
				return "backend_user/index";
			}
		}
		log.info("登陆失败！请检查开发者用户名和密码！");
		return "backend_user/login";
	}
	
}
