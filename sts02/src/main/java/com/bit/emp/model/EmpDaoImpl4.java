package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class EmpDaoImpl4 implements EmpDao {
	JdbcTemplate jdbcTemplate;
	
	PlatformTransactionManager transactionManager;
	
	public EmpDaoImpl4(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
		this.jdbcTemplate=jdbcTemplate;
		this.transactionManager=transactionManager;
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
		final String sql="select * from emp";
		PreparedStatementCreator psc=new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				return conn.prepareStatement(sql);
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		
		TransactionStatus status1=null;
		TransactionStatus status2=null;
		TransactionDefinition definition1=new DefaultTransactionDefinition();
		TransactionDefinition definition2=new DefaultTransactionDefinition();
		status1=transactionManager.getTransaction(definition1);
		status2=transactionManager.getTransaction(definition2);
		
		try {
			PreparedStatementCreator psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("첫번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno());
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
//			transactionManager.commit(status1);
			System.out.println("status1:"+status1);
		}catch(Exception e){
			transactionManager.rollback(status1);
		}
		try {
			PreparedStatementCreator psc=new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("두번째 conn:"+conn.hashCode());
					String sql="insert into emp (empno,ename,sal,job,hiredate) value (?,?,?,?,now())";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getEmpno()+1);
					pstmt.setString(2, bean.getEname());
					pstmt.setInt(3, bean.getSal());
					pstmt.setString(4, bean.getJob());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			transactionManager.commit(status2);
			System.out.println("status2:"+status2);
		}catch(Exception e){
			transactionManager.rollback(status2);
		}
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpVo selectOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
