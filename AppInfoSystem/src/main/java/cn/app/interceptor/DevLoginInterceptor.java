package cn.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.app.pojo.DevUser;



/**
 * 开发者用户登录拦截器
 * @author lenovo
 *
 */
public class DevLoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response) throws Exception{
		DevUser devUser=(DevUser)request.getSession().getAttribute("devUser1");
		if(devUser==null){
			response.sendRedirect(request.getContextPath()+"/dev/login");
			return false;
		}else{
			return true;
		}
	}
}
