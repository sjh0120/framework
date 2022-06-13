package com.bit.sts08.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("preHandle..."+((HandlerMethod)handler));
		//request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		//response.getWriter().print("<h1>·Î±×ÀÎ</h1>");
		//return false;
		
		HttpSession session=request.getSession();
		if(session.getAttribute("result")==null) {
			response.sendRedirect("/sts08/login/");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
//		System.out.println("postHandle...");
//		System.out.println(mav.getViewName());
//		System.out.println(mav.getModel());
	}
}
