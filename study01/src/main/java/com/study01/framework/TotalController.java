package com.study01.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TotalController {

	String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
