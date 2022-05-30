package com.study01.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DispatcherServlet extends HttpServlet{
	private SimpleViewResolver resolver;
	private SimpleHandlerMapping handler;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dispatcher start...");
		//req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
		resolver.setSuffix("/WEB-INF/views/");
		resolver.setPrefix(".jsp");
		
		
		String url=req.getRequestURI().substring(req.getContextPath().length());
		System.out.println(url);
		
		TotalController controller=null;
		controller=handler.getMapping().get(url);
		
		String viewName="";
		try {
			viewName=controller.execute(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		resolver.viewResolver(viewName,req,resp);
	}
}
