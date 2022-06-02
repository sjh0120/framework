package com.bit.emp;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.emp.model.EmpVo;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		EmpVo bean=(EmpVo) ac.getBean("bean");
		
//		long su=new java.util.Date().getTime();
//		Date hiredate=new Date(su);
//		bean.setHiredate(hiredate);
//		System.out.println(bean.getArr5());
//		System.out.println(Arrays.toString(bean.getArr5()));
		
	}

}
