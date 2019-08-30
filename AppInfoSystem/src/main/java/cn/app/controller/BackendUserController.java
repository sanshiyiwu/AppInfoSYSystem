package cn.app.controller;

<<<<<<< HEAD
=======
import java.util.Date;
import java.util.List;

>>>>>>> 2d2a908755195c40a52c0b3341f162e0e02aee6b
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
<<<<<<< HEAD
	
=======
	/**
	 * 展示后台管理用户列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/showBackend_userList")
	public String showBackend_userList(HttpSession session){
		log.info("展示后台管理用户列表..");
		List<BackendUser> backendUserList=backendUserService.getBackendUserList();
		session.setAttribute("backendUserList", backendUserList);
		return "backend_user/showBackend_userList";
	}
	/**
	 * 展示增加后台管理用户界面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addBackend_user")
	public String addBackend_user(HttpSession session){
		log.info("展示增加后台管理用户界面..");
		return "backend_user/addBackend_user";
	}
	/**
	 * 执行增加后台管理用户
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addBackend_userSave")
	public String addBackend_userSave(BackendUser user,HttpSession session){
		log.info("执行增加后台管理用户..");
		Integer result=backendUserService.addBackendUser(user);
		if(result!=0){
			log.info("执行成功！");
			user.setCreatedBy(((BackendUser)session.getAttribute("presentCust")).getId());
			user.setCreationDate(new Date());
			return "backend_user/showBackend_userList";
		}else{
			log.info("执行失败！返回增加界面...");
			return "backend_user/addBackend_user";
		}
	}
	/**
	 * 显示修改后台管理用户的页面
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updBackend_user")
	public String updUser(@RequestParam("id")int id,HttpSession session){
		log.info("显示修改后台管理用户的页面..");
		BackendUser backendUser=backendUserService.getBackendUserById(id);
		session.setAttribute("backendUser", backendUser);
		return "backend_user/updBackend_user";
	}
	/**
	 * 执行修改后台管理用户
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updBackend_userSave")
	public String updBackend_userSave(BackendUser user,HttpSession session){
		log.info("执行修改后台管理用户..");
		Integer result=backendUserService.updBackendUser(user);
		if(result!=0){
			log.info("执行成功！");
			user.setModifyBy(((BackendUser)session.getAttribute("presentCust")).getId());
			user.setModifyDate(new Date());
			return "backend_user/showBackend_userList";
		}else{
			log.info("执行失败！返回增加界面...");
			return "backend_user/updBackend_user";
		}
	}
	/**
	 * 执行删除后台管理用户
	 */
	@RequestMapping(value="/delBackend_user")
	public String delBackend_user(@RequestParam("id")int id,HttpSession session){
		log.info("执行删除后台管理用户..");
		Integer result=backendUserService.delBackendUser(id);
		if(result!=0){
			log.info("执行成功！");
			return "backend_user/showBackend_userList";
		}else{
			log.info("执行失败！返回列表界面...");
			return "backend_user/showBackend_userList";
		}
	}
>>>>>>> 2d2a908755195c40a52c0b3341f162e0e02aee6b
	
	
}
