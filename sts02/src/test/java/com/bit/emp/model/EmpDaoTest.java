package com.bit.emp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	static EmpDao empDao;
	static EmpVo target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
//		empDao=(EmpDao)ac.getBean("empDao");
//		empDao=ac.getBean(new EmpDaoImpli1().getClass);
		empDao=ac.getBean(EmpDao.class);
		target=new EmpVo(
				30,30,"test30","test30",null
				);
	}

	@Before
	public void setUp() throws Exception {
		assertNotNull(empDao);
	}

	@Test
	public void test1SelectAll() throws SQLException {
		assertNotEquals(0, empDao.selectAll().size());
	}
	
	@Test
	public void test2InsertOne() throws SQLException{
		empDao.insertOne(target);
	}
	
	@Test
	public void test3UpateOne() throws SQLException{
		target.setEname("한글");
		assertEquals(1,empDao.updateOne(target));
	}
	
	@Test
	public void test4SelectOne() throws SQLException{
		assertEquals(target,empDao.selectOne(target.getEmpno()));
	}
	
	@Test
	public void test5DeleteOne() throws SQLException{
		assertEquals(1,empDao.deleteOne(target.getEmpno()));
	}
	
}
