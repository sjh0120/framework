package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Controller
//xml������ ��ü ������ ����
//������ �߻��� component-scan������ �����ϱ� ���ؼ�
//������̼����� �ٷ� �ùٸ� ��ü�� �����ǵ��� �ؾ���!
//���� @Component�� ����Ѵ�!

//�����ڿ� ���� ��ð� ���� ������ setter�� �� �� ���� => autowired�� �ʿ�� �ȴ�!

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
