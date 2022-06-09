package com.bit.sts06.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDao01ImplTest {
//	slf4j를 통해서 밑의 2줄 기능을 대체하고있다!
//	slf4j에 넣는 log에 따라 서로 다른 logger의 기능을 할 수 있다
//	Logger log=Logger.getLogger(EmpDao01ImpTest.class);
//	Logger log=LoggerFactory.getILoggerFactory(EmpDao01ImpTest.class);
	static EmpDao empDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		empDao=ac.getBean(EmpDao.class);
	}

	private int cnt;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() throws Exception {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		cnt=empDao.findAll().size();
		assertNotEquals(0, cnt);
		log.debug("size:"+cnt);
	}
	
	@Test
	public void test2() throws Exception {
		assertNotNull(empDao);
		try {
			log.debug(empDao.findOne(1).toString());
//			fail();
		}catch(Exception e) {
		}
		assertNotNull(empDao.findOne(2));
		
	}

	@Test
//	@Transactional
//	@Rollback(true)
	public void test3() throws Exception{
		assertNotNull(empDao);
		EmpVo target=new EmpVo(15,15,"test15","test15",null);
//		int before=empDao.findAll().size();
		empDao.insertOne(target);
//		assertEquals(before, empDao.findAll().size());
		assertEquals(1,empDao.updateOne(target));
		assertEquals(1,empDao.deleteOne(target.getEmpno()));
	}
	@Test
	public void test4() throws Exception {
		log.debug("size:"+empDao.findSize());
	}
	
}
