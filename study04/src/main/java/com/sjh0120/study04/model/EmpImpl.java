package com.sjh0120.study04.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpImpl implements EmpDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpVo> findAll() throws SQLException {
		return sqlSession.selectList("emp.selectAll");
	}

	@Override
	public EmpVo findOne(int idx) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {

	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		return 0;
	}

}
