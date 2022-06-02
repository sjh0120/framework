package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmpDaoImpl3 implements EmpDao {
	JdbcTemplate jdbcTemplate;
	
	public EmpDaoImpl3(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"),rs.getInt("sal")
					,rs.getString("ename"), rs.getString("job")
					,rs.getDate("hiredate")
					);
		}
	};
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql="select * from emp";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job,hiredate) values(?,?,?,?,now())";
		jdbcTemplate.update(sql,bean.getEmpno(),bean.getEname(),bean.getSal(),bean.getJob());
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		return jdbcTemplate.update(sql,bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		String sql="delete from emp where empno=?";
		return jdbcTemplate.update(sql,num);
	}

	@Override
	public EmpVo selectOne(int num) throws SQLException {
		String sql="select * from emp where empno=?";
		return jdbcTemplate.queryForObject(sql,rowMapper,num);
	}

}
