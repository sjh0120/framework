package com.study01.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study01.framework.TotalController;


public class IndexController implements TotalController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "index";
	}

}
