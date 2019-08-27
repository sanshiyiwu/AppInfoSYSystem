package cn.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.app.pojo.BackendUser;



/**
 * 后台管理系统登录拦截器
 * @author lenovo
 *
 */
public class BackendLoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response) throws Exception{
		BackendUser backendUser=(BackendUser)request.getSession().getAttribute("backendUser1");
		if(backendUser==null){
			response.sendRedirect(request.getContextPath()+"/backend/login");
			return false;
		}else{
			return true;
		}
	}
}
