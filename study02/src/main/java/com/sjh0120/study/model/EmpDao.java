package com.sjh0120.study.model;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao<T> {
	
	List<T> findAll() throws SQLException;
	void insertOne(T obj) throws SQLException;
	T findOne(int idx) throws SQLException;
	int updateOne(T obj) throws SQLException;
	int deleteOne(int idx) throws SQLException;
}
