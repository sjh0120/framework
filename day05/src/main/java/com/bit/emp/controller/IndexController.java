package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.framework.BitController;

public class IndexController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "index";
	}

}
