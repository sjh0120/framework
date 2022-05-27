package com.bit.frame.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.frame.model.entity.EmpVo;

public abstract class QueryTemplate {
	Connection conn;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	
	public List<EmpVo> executeQuery(String sql) throws SQLException{
		List<EmpVo> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		////
		try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMapper(rs));
			}
		} finally {
			close(conn,pstmt,rs);
		}
		return list;
	}
	public EmpVo QueryForObject(String sql) throws SQLException{
		return executeQuery(sql).get(0);
	}
	
	public abstract EmpVo rowMapper(ResultSet rs) throws SQLException;
}
