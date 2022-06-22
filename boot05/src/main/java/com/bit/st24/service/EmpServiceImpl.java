package com.bit.st24.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.bit.st24.repository.EmpRepo;
import com.bit.st24.repository.domain.Emp;

@Service
public class EmpServiceImpl {

	@Autowired
	EmpRepo empRepo;
	
	public List<Emp> selectAll(){
		return empRepo.findAll();
	}
	
	public Object insertOne(Emp bean) {
		return empRepo.insertOne(bean);
	}
}
