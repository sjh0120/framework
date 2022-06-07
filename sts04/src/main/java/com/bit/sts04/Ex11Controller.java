package com.bit.sts04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Ex11Controller {

//	@RequestMapping(value={"/ex11","/test11"},method=RequestMethod.GET)
	@RequestMapping("ex11")
	public String ex11() {
//		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
//		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
//		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		//if(func()==TestEm.msg1)System.out.println(TestEm.msg1);
		return "ex01";
	}
	
	@RequestMapping("ex12")
	public String ex12() {
		return "ex01";
	}
	
	/*
	 * public TestEm func() { return TestEm.msg1; }
	 */
	
	/*
	Calendar.YEAR, RequestMethod.GET => enum객체(?)
	public class Ex11Controller의 리퀘스트 맵핑 -> 아래의 자식클래스들이 공통적으로 사용하는 것을 묶어둔 것!
	*/
}
