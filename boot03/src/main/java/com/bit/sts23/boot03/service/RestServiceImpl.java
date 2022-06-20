package com.bit.sts23.boot03.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bit.sts23.boot03.mapper.DeptMapper;
import com.bit.sts23.boot03.mapper.domain.Dept;


@Service
public class RestServiceImpl {

	private final DeptMapper deptMapper;
	
	public RestServiceImpl(DeptMapper deptMapper) {
//	@RequiredArgsConstructor
		this.deptMapper=deptMapper;
	}
//	이 생성자의 역할을 하는게 @RequiredArgsConstructor / 버전때문인지 지금 안됨
	
	public List<Dept> selectAll(){
		return deptMapper.findAll();
	}
	
	public Dept selectOne(int idx) {
		return deptMapper.findOne(idx);
	}
	
	public int insertOne(Dept bean) {
		return deptMapper.insertOne(bean);
	}
	
	public int updateOne(Dept bean) {
		return deptMapper.updateOne(bean);
	}
	
	public int deletOne(int idx) {
		return deptMapper.deleteOne(idx);
	}
}
