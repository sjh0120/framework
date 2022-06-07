package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex01Controller {
	public Ex01Controller() {
		System.out.println("Ex01 create...");
	}

	@RequestMapping(value = "/ex01")
	public ModelAndView ex01(HttpServletRequest req, HttpServletResponse res) {
		
		return new ModelAndView("ex01","msg","hello");
	}
}
/*
 인터페이스 상속을 통한 맵핑 -> xml파일에서 핸들러 맵핍을 해줘야함!
 어노테이션을 통한 맵핑 -> 리퀘스트맵핑을 해주면됨!
 */
 