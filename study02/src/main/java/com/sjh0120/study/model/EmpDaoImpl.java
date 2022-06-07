package com.sjh0120.study.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmpDaoImpl implements EmpDao<EmpVo> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(rs.getInt("empno"),rs.getInt("sal"),rs.getString("ename"),rs.getString("job"));
		}
	};
	
	@Override
	public List<EmpVo> findAll() throws SQLException {
		String sql="select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void insertOne(EmpVo obj) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		jdbcTemplate.update(sql,obj.getEmpno(),obj.getEname(),obj.getSal(),obj.getJob());
	}

	@Override
	public EmpVo findOne(int idx) throws SQLException {
		String sql="select * from emp where empno=?";
		return jdbcTemplate.queryForObject(sql,mapper,idx);
	}

	@Override
	public int updateOne(EmpVo obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		String sql="delete from emp where empno=?";
		return jdbcTemplate.update(sql,idx);
	}
	
	

}
