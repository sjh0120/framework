package com.bit.framework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BitController {

	String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
