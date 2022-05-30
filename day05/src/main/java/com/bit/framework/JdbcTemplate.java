package com.bit.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class JdbcTemplate<T> {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSource;
	
	public JdbcTemplate() {
	}
	
	public JdbcTemplate(DataSource dataSource) throws SQLException {
		this.dataSource=dataSource;
	}
	
	public void setDataSource(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
	}
	
	public int executeUpdate(String sql, Object ...objs) throws SQLException{
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) {
				pstmt.setObject(1+i, objs[i]);
			}
			return pstmt.executeUpdate();	
		}finally {
			close();
		}
	}
	
	public void close() throws SQLException{
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public T queryForObject(String sql, RowMapper<T> mapper, Object ...objs) throws SQLException {
		return queryForList(sql,mapper,objs).get(0);
	}
	
	public List<T> queryForList(String sql,RowMapper<T> mapper) throws SQLException{
		return queryForList(sql,mapper,new Object[] {});
	}
	public List<T> queryForList(String sql,RowMapper<T> mapper ,Object ...objs) throws SQLException{
		List<T> list=new ArrayList<T>();
		Connection conn=dataSource.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) pstmt.setObject(1+i, objs[i]);
			rs=pstmt.executeQuery();
			while(rs.next()) list.add(mapper.rows(rs));
		}finally {
			close();
		}
		return list;
	}
}
