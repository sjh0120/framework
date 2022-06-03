package com.bit.frame.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AroundMethod implements MethodInterceptor {
	Logger log=Logger.getLogger(this.getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
//		방법1
//		try{
//			System.out.println("around...before");
//			return invocation.proceed();
//		}finally {
//			System.out.println("around...after");
//		}
		
//		방법2
//		System.out.println("around...before");
//		Object obj=invocation.proceed();
//		System.out.println("around...after");
//		return obj;
		
		/*
		방법1 방법2 차이 존재!
		방법1 -> 에러떠도 무조건 실행
		방법2 -> 에러뜨면 실행에서 멈춰버림!
		해결책 => 방법3
		*/
		
//		방법3
		log.debug("around...before");	// 실행 전 작동 => before 메소드
		Object obj=null;						// obj => afterReturning의 returnValue
		try{
			obj=invocation.proceed();			// 실제 실행 시점!
			log.debug("around...returning");	// 실행 완료시 작동 => after메소드
		}catch (Exception e) {
			log.debug("around...exception");	// exception 발생 시 작동 => exception메소드
		}
		return obj;
	}
}
