package com.sjh0120.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjh0120.model.EmpDao;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		req.setAttribute("list", dao.selectAll());
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}
	
}
