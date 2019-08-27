package cn.app.controller;

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
@RequestMapping("/backend/index")
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
		return "backend/index";
	}
	
	
	
}
