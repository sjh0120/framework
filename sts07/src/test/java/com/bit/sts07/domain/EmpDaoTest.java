package com.bit.sts07.domain;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {

	static EmpDao empDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac=null;
//		ac=new GenericXmlApplicationContext("/WEB-INF/spring/root-context.xml");
		
		//방법 3개
//		new ClassPathXmlApplicationContext("/application-context.xml");
//		new FileSystemXmlApplicationContext("c:\\~~~\root-context.xml");
//		new FileSystemXmlApplicationContext("./src/main~/root-context.xml");
		
		//방법 1
		//classpath로 할때에는
		//ac=new GenericXmlApplicationContext("classpath:/WEB-INF/spring/root-context.xml");
		//방법 2,3
		//ac=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		//new FileSystemXmlApplicationContext("c:\\~~~\root-context.xml"); //절대경로
		//또는
		//new FileSystemXmlApplicationContext("./src/main~/root-context.xml"); //상대경로
		
		ac=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		empDao=ac.getBean(EmpDao.class);
		
		
		
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testDataSource() throws SQLException{
		ApplicationContext ac=null;
		ac=new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
//		assertNotNull(ac.getBean(DataSource.class));
		ac.getBean(DataSource.class).getConnection().close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		assertNotEquals(0,empDao.findAll().size());
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testAllSize() {
		fail("Not yet implemented");
	}

}
