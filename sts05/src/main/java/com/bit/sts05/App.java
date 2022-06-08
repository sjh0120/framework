package com.bit.sts05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts05.service.MyModule;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		MyModule module=ac.getBean(MyModule.class);
		
//		module.func01();
		
		module.func02(1234);
//		System.out.println(module.func03());

		/*
		after run value:세번째
		세번째
		출력결과가 이렇게 되는 이유
		System.out.println(module.func03());는 사실
		
		String msg=module.func03();
		System.out.println(msg);
		이므로 module.func03()이 처리되는 기점으로 부터 before / after가 실행되기 때문이다!
		그래서 마지막의 '세번째'는 따로 나온 것이다
		*/
		
//		module.func04();
		
	}

}
