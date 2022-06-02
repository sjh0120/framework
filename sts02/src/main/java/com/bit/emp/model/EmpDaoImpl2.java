package com.bit.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmpDaoImpl2 extends JdbcDaoSupport implements EmpDao {

	//case 1
	public EmpDaoImpl2(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}
//	
//	//case 2
//	public EmpDaoImpl2(DataSource dataSource) {
//		setDataSource(dataSource);
//	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		String sql="select * from emp";
		RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),0,rs.getNString("ename"),null,rs.getDate("hiredate")
						);
			}
		};
		return getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job,hiredate) values(?,?,?,?,now())";
		getJdbcTemplate().update(sql,bean.getEmpno(),bean.getEname(),bean.getSal(),bean.getJob());
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?, job=?,sal=? where empno=?";
		return getJdbcTemplate().update(sql,bean.getEname(),bean.getJob(),bean.getSal(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		String sql="delete from emp where empno=?";
		return getJdbcTemplate().update(sql,num);
	}

	@Override
	public EmpVo selectOne(int num) throws SQLException {
		String sql="select * from emp where empno=?";
		RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),rs.getInt("sal")
						,rs.getNString("ename"),rs.getString("job")
						,rs.getDate("hiredate")
						);
			}
		};
		return getJdbcTemplate().queryForObject(sql, rowMapper,num);
	}

	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

}
