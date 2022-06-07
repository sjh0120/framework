package com.bit.stst04.model;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Emp01DaoImplTest {
	
	final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public Emp01DaoImplTest(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename")
					,rs.getString("job"),rs.getTimestamp("hiredate")
					);
		}
	};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAll() {
		String sql="select * from emp";
		assertNotNull(jdbcTemplate.query(sql,mapper));
	}

}
