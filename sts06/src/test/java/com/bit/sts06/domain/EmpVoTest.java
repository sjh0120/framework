package com.bit.sts06.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpVoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		EmpVo bean=new EmpVo();
		EmpVo bean2=new EmpVo(111,1111,"test","test",null);
		bean.setEmpno(1111);
		bean2.setEmpno(1111);
		System.out.println(bean.getEmpno());
		System.out.println(bean);
		System.out.println(bean.equals(bean2));
	}

}
