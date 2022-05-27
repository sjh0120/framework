package com.bit.frame.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.frame.model.EmpDao;
import com.bit.frame.util.MyController;

public class DetailController implements MyController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empno=Integer.parseInt(request.getParameter("empno"));
		EmpDao dao=new EmpDao();
		try {
			request.setAttribute("bean", dao.selectOne(empno));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "emp/detail";
	}
}
