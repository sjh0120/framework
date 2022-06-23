package com.bit.sts251.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts251.domain.Emp;
import com.bit.sts251.domain.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmpServiceImpl {
	private final EmpMapper empMapper;
	@Autowired
	HttpSession session;
	
	public List<Emp> getList(){
		log.debug(session.getId());
		return empMapper.findAll();
	} 
	
	public Emp addList(Emp emp) {
		log.debug(session.getId());
		return empMapper.insertOne(emp)>0?emp:null;
	}
	

	
}
