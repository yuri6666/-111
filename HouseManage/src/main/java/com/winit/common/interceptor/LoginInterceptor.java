package com.winit.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.winit.common.utils.SessionUtil;


/**
 * 配置用户登录权限拦截
 * 
 * @author
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
	
		String currenturl;
		String paramStr = request.getQueryString();
		if ("".equals(paramStr) || paramStr == null) {
			currenturl = request.getRequestURL().toString();
		} else {
			currenturl = request.getRequestURL().append("?").append(paramStr)
					.toString();
		}
		if(currenturl.indexOf("web/manage") != -1){
			if(SessionUtil.getUserDetail(session) == null ){
				String path=getFullPath(request)+"web/visitor/toLogin";
				if(path.indexOf("443")!=-1){
					path=StringUtils.replace(path, "443", "80");
				}
				judgerequest(request,response,request.getSession(),path);
		        return false;
			}
			return true;
		}
		  return true; 
	}
	
	
	
	/**
	 * 判断是ajax请求session失效,还是判断那种请求失效
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	public void judgerequest(HttpServletRequest request,HttpServletResponse response,HttpSession session,String path) throws Exception{
		String type = request.getHeader("X-Requested-With");// XMLHttpRequest
		if (StringUtils.equals("XMLHttpRequest", type)) {
			// ajax请求
			response.setHeader("SESSIONSTATUS", "TIMEOUT");
			response.setHeader("CONTEXTPATH", path);
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			} else {
			response.sendRedirect(path);
			}
		   session.setAttribute("current_patiurl", request.getHeader("Referer"));
		
	}
	
	

	/**
	 * 得到地址全路径
	 * @param args
	 */
	public String getFullPath(HttpServletRequest request){
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
  
  


	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}


	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
