package com.sjh0120.study05.bootStudy01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sjh0120.study05.bootStudy01.mapper.EmpMapper;
import com.sjh0120.study05.bootStudy01.mapper.domain.Emp;

@Service
public class EmpImpl {

	private final EmpMapper empMapper;
	
	public EmpImpl(EmpMapper empMapper) {
//		@RequiredArgsConstructor
			this.empMapper=empMapper;
		}
	
	public List<Emp> selectAll(){
		return empMapper.findAll();
	};
	
	public Emp selectOne(@RequestBody int empno) {
		return empMapper.findOne(empno);
	};
	
	public int insertOne(@RequestBody Emp bean) {
		return empMapper.insertOne(bean);
	}
	
	public int updateOne(@RequestBody Emp bean) {
		return empMapper.updateOne(bean);
	}
	
	public int deleteOne(@RequestBody int empno) {
		return empMapper.deleteOne(empno);
	}
	
}
