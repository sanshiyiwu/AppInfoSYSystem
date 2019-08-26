package cn.app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器
 * @author wjy
 *
 */
@Controller
@RequestMapping()	
public class TestController {
	private Logger log = Logger.getLogger(TestController.class);
	
	@RequestMapping(value = "/index")
	public String test() {
		log.info("进入test方法;参数:>>");
		return "index";
	}
}
