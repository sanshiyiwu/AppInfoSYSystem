package cn.app.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.entity.BackendUser;
import cn.app.service.BackendUserService;




/**
 * 后台管理系统用户控制器
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/backend_user/index")
public class BackendUserController {
	/**
	 * 打印日志文件
	 */
	private Logger log=Logger.getLogger(BackendUserController.class);
	/**
	 * 获取后台管理系统用户服务BackendUserService
	 */
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping(value="/index")
	public String index(){
		log.info("正在跳转至首页页面..");
		return "backend_user/index";
	}
	
	@RequestMapping(value="/showBackend_userList")
	public String showBackend_userList(HttpSession session){
		log.info("展示后台管理用户列表..");
		List<BackendUser> backendUserList=backendUserService.getBackendUserList();
		session.setAttribute("backendUserList", backendUserList);
		return "backend_user/showBackend_userList";
	}
	@RequestMapping(value="/addBackend_user")
	public String addBackend_user(HttpSession session){
		log.info("展示增加后台管理用户界面..");
		return "backend_user/addBackend_user";
	}
	@RequestMapping(value="/updUser")
	public String updUser(@RequestParam("id")int id,HttpSession session){
		log.info("显示修改后台管理用户的页面..");
		BackendUser backendUser=backendUserService.getBackendUserById(id);
		session.setAttribute("backendUser", backendUser);
		return "backend_user/updUser";
	}
	
	
}
