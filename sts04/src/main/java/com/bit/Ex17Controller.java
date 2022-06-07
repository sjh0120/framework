package com.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

@Controller
public class Ex17Controller {

	@RequestMapping("/ex17")
	public String ex17() {
//		HandlerMapping a=null;
		//default annotaion handlermapping이 생략되어져 있는 것!
		return "ex01";
	}
}
