package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Controller
//xml에서의 객체 생성을 막고
//웹에서 발생할 component-scan에러를 방지하기 위해서
//어노테이션으로 바로 올바른 객체가 생성되도록 해야함!
//따라서 @Component를 사용한다!

//생성자에 대한 명시가 없기 때문에 setter를 쓸 수 없다 => autowired가 필요시 된다!

@Component
@Aspect
public class UserBefore {

	@Before(value="execution(* com.bit.sts05.service.MyModule.*(..))")
	public void beforeTargetMethod(JoinPoint point) {
		Class cls=point.getSignature().getDeclaringType();
		String name=point.getSignature().getName();
		Object[] args= point.getArgs();
        System.out.println("method before run..."+point);
        System.out.println("class -->"+cls);
        System.out.println("name -->"+name);
        System.out.println(Arrays.toString(args));

    }
}
