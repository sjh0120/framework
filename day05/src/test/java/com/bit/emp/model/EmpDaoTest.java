package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpDaoTest {
	EmpDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao=new EmpDao();
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void testInsertOne() throws SQLException{
//		dao.dataSource.getConnection().setAutoCommit(false);
//		//autocommit이 왜 되지?
//		EmpVo target=new EmpVo(17,17,"test17","test17");
//		try {
//			dao.insertOne(target);
//			assertFalse(false);
//		}catch(Exception e) {
//			assertFalse(true);
//		}
////		dao.conn.setAutoCommit(false);
////		EmpVo target=new EmpVo(8,8,"test8","test8");
////		try {
////			dao.insertOne(target);
////			assertFalse(true);
////		}catch (Exception e) {
////			assertFalse(false);
////		}
		
	}
	
	@Test
	public void testDeleteOne() throws SQLException {
		assertSame(1, dao.deleteOne(10));
	}
}
