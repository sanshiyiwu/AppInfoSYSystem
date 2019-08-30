package cn.app.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.entity.DevUser;
import cn.app.service.DevUserService;


/**
 * 开发者用户控制器
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/dev_user/index")
public class DevUserController {
	/**
	 * 打印日志文件
	 */
	private Logger log=Logger.getLogger(DevUserController.class);
	/**
	 * 获取开发者用户服务DevUserService
	 */
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping(value="/index")
	public String index(){
		log.info("正在跳转至首页页面..");
		return "dev_user/index";
	}
	/**
	 * 展示开发者用户列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/showDev_userList")
	public String showDev_userList(HttpSession session){
		log.info("展示开发者用户列表..");
		List<DevUser> DevUserList=devUserService.getDevUserList();
		session.setAttribute("DevUserList", DevUserList);
		return "Dev_user/showDev_userList";
	}
	/**
	 * 展示增加开发者用户界面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addDev_user")
	public String addDev_user(HttpSession session){
		log.info("展示增加开发者用户界面..");
		return "Dev_user/addDev_user";
	}
	/**
	 * 执行增加开发者用户
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addDev_userSave")
	public String addDev_userSave(DevUser user,HttpSession session){
		log.info("执行增加开发者用户..");
		Integer result=devUserService.addDevUser(user);
		if(result!=0){
			log.info("执行成功！");
			user.setCreatedBy(((DevUser)session.getAttribute("presentCust")).getId());
			user.setCreationDate(new Date());
			return "Dev_user/showDev_userList";
		}else{
			log.info("执行失败！返回增加界面...");
			return "Dev_user/addDev_user";
		}
	}
	/**
	 * 显示修改开发者用户的页面
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updDev_user")
	public String updUser(@RequestParam("id")int id,HttpSession session){
		log.info("显示修改开发者用户的页面..");
		DevUser DevUser=devUserService.getDevUserById(id);
		session.setAttribute("DevUser", DevUser);
		return "Dev_user/updDev_user";
	}
	/**
	 * 执行修改开发者用户
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updDev_userSave")
	public String updDev_userSave(DevUser user,HttpSession session){
		log.info("执行修改开发者用户..");
		Integer result=devUserService.updDevUser(user);
		if(result!=0){
			log.info("执行成功！");
			user.setModifyBy(((DevUser)session.getAttribute("presentCust")).getId());
			user.setModifyDate(new Date());
			return "Dev_user/showDev_userList";
		}else{
			log.info("执行失败！返回增加界面...");
			return "Dev_user/updDev_user";
		}
	}
	/**
	 * 执行删除开发者用户
	 */
	@RequestMapping(value="/delDev_user")
	public String delDev_user(@RequestParam("id")int id,HttpSession session){
		log.info("执行删除开发者用户..");
		Integer result=devUserService.delDevUser(id);
		if(result!=0){
			log.info("执行成功！");
			return "Dev_user/showDev_userList";
		}else{
			log.info("执行失败！返回列表界面...");
			return "Dev_user/showDev_userList";
		}
	}
	
	
	
	
}
