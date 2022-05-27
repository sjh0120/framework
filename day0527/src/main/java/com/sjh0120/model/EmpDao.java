package com.sjh0120.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sjh0120.model.entity.EmpVo;

public class EmpDao {

	public List<EmpVo> selectAll(){
		String sql="select * from emp";
		List<EmpVo> arr=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user="user01";
		String password="1234";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpVo bean=new EmpVo();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setJob(rs.getString("job"));
				bean.setSal(rs.getInt("sal"));
				arr.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
}
