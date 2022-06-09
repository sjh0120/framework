package com.sjh0120.study03.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpImpl implements EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<EmpVo> mapper=new RowMapper<EmpVo>() {
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(rs.getInt("empno"),rs.getInt("sal")
					,rs.getString("ename"),rs.getString("job"));
		}
	};
	
	@Override
	public List<EmpVo> findAll() throws Exception {
		String sql="select * from emp";
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public void insertOne(EmpVo bean) throws Exception {
		String sql="insert into emp(empno,ename,sal,job) values(?,?,?,?)";
		jdbcTemplate.update(sql,bean.getEmpno(),bean.getEname(),bean.getSal(),bean.getJob());
	}

}
