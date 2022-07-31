package com.wmc.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	HttpSession session = request.getSession();
	String url = null;
	url = request.getRequestURL().toString();
	url = URLEncoder.encode(url,"utf-8");
	if(session.getAttribute("login") == null) {
		response.sendRedirect(request.getContextPath()+"/member/login?url="+url);
		return false;	//로그인 페이지로 자동 이동되고, 실행됐던 작업은 중단됨.
	}
	return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
			
		super.afterCompletion(request, response, handler, ex);
	}

}
