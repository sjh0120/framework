package com.sjh0120.study03.domain;

import java.util.List;

public interface EmpDao {

	List<EmpVo> findAll() throws Exception;
	void insertOne(EmpVo bean) throws Exception;
}
