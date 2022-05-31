package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Emp03Dao extends JdbcDaoSupport implements EmpDao{
//	private String msg;
	
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
	
	//super로 부모에 dataSource를 넣어주기 때문에 빼야함
//	private DataSource dataSource;

//	public Emp03Dao() {
//		MysqlDataSource dataSource=new MysqlDataSource();
//		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
//		dataSource.setUser("user01");
//		dataSource.setPassword("1234");
//		//super로 부모에 dataSource를 넣어주기 때문에 빼야함
////		this.dataSource=dataSource;
//		super.setDataSource(dataSource);
//	}
	
	public Emp03Dao() {
		System.out.println("new Dao...");
	}
	
	@Override
	public List<EmpVo> selectAll() throws SQLException{
		String sql="select * from emp";
		RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
			
			@Override
			public EmpVo mapRow(java.sql.ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),rs.getString("ename")
						,rs.getInt("sal"),rs.getString("job")
						);
			};
		};
		JdbcTemplate template=getJdbcTemplate();
		//super로 부모에 dataSource를 넣어주기 때문에 빼야함
//		template.setDataSource(dataSource);
		//getJdbcTemplate()하기 전에 super.setDataSource(dataSource)를 해주기만 하면 됨!
		return template.query(sql, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		JdbcTemplate template=getJdbcTemplate();
		template.update(sql,new Object[] {bean.getEmpno(),bean.getEname(),bean.getSal(),bean.getJob()});
	}

	@Override
	public EmpVo selectOne(int parseInt) throws SQLException {
		String sql="select * from emp where empno=?";
		JdbcTemplate template=getJdbcTemplate();
		RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new EmpVo(
						rs.getInt("empno"),rs.getString("ename")
						,rs.getInt("sal"),rs.getString("job")
						);
			}
		};
		return template.queryForObject(sql,new Object[] {parseInt},rowMapper);
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		return getJdbcTemplate().update(sql,bean.getEname(),bean.getSal(),bean.getJob(),bean.getEmpno());
	}

	@Override
	public int deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		return getJdbcTemplate().update(sql,empno);
	}
}
