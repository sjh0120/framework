package com.bit.frame.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpDaoImplTest {
	EmpVo target=new EmpVo(41,41,"test41","test41",new Date(2022,06,03));
	EmpDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAll() {
		
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

}
