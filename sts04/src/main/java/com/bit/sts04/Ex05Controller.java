package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

public class Ex05Controller {

	@RequestMapping("/ex05")
	public String ex05(HttpServletRequest req) {
		req.setAttribute("msg", "ex05 page");
		return "ex01";
	}
}