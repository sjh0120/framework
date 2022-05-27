package com.bit.frame.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.frame.model.EmpDao;
import com.bit.frame.util.MyController;

public class AddController implements MyController{
	
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "emp/add";
	}

	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		int sal=Integer.parseInt(req.getParameter("sal"));
		EmpDao dao=new EmpDao();
		
		try {
			dao.insertOne(empno,ename,job,sal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list.bit";
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equals("GET")) return doGet(request,response);
		else if(request.getMethod().equals("POST")) return doPost(request,response);

		return null;
	}
}

//public class AddController extends HttpServlet {
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);;
//	}
//	
//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int empno=Integer.parseInt(req.getParameter("empno"));
//		String ename=req.getParameter("ename");
//		String job=req.getParameter("job");
//		int sal=Integer.parseInt(req.getParameter("sal"));
//		EmpDao dao=new EmpDao();
//		
//		try {
//			dao.insertOne(empno,ename,job,sal);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		resp.sendRedirect("list.bit");
//	}
//}
