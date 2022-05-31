package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emp03Dao {
	public List<EmpVo> selectAll() throws ClassNotFoundException, SQLException{
		String sql="select * from emp";
		
		return null;
	}

	public void insertOne(EmpVo bean) throws ClassNotFoundException, SQLException {
		String sql="insert into emp (empno,ename,sal,job) values (?,?,?,?)";
		
		
	}

	public EmpVo selectOne(int parseInt) throws SQLException {
		String sql="select * from emp where empno=?";
		
		return null;
	}

	public int updateOne(EmpVo bean) throws SQLException {
		String sql="update emp set ename=?,sal=?,job=? where empno=?";
		
		return 0;
	}

	public int deleteOne(int empno) throws SQLException {
		String sql="delete from emp where empno=?";
		
		return 0;
	}
}
