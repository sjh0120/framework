package com.bit.sts07;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts07.domain.EmpDao;
import com.bit.sts07.domain.EmpVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
//@Controller
//@ResponseBody
//위의 2가지를 동시에 실행하는 어노테이션이 @RestController이다!
@RestController
public class ApiController {

	@Autowired
	EmpDao empDao;
	
	/*
	200번 ok나옴
	@RequestMapping("/test")
	public @ResponseBody void test() {
	}
	*/
	
	@RequestMapping("/test")
	public Object test() {
		Map<String,Object> map=new HashMap<>();
		map.put("empno", 1111);
		map.put("ename", "tester");
		map.put("arr", new ArrayList<>());
		return new EmpVo();
	}
	
//	@RequestMapping(value="/emp", method=RequestMethod.GET)
	@GetMapping("/emp")
	public List<EmpVo> list() throws SQLException{
		List<EmpVo> list=empDao.findAll();
		return list;
	}
	
	@PostMapping("/emp")
	public void add(@ModelAttribute EmpVo bean) throws SQLException{
		//log.debug("insert:"+bean.toString());
		empDao.insertOne(bean);
	}
	
	@GetMapping("/emp/{empno}")
	public EmpVo detail(@PathVariable int empno) throws SQLException {
		EmpVo bean=empDao.findOne(empno);
		return bean;
	}
	
	//responsebody와 requestbody를 어떻게 알고 데이터를 묶어주는가?
	// -> pom.xml에 있는 jackson-databind를 통해서 데이터를 묶어준다!
	@PutMapping("/emp/{empno}")
	public void update(@RequestBody EmpVo bean){
		log.debug("update:"+bean);
		int result=0;
		try {
			result=empDao.updateOne(bean);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if(result==0)
			throw new IllegalArgumentException("수정안됨");
		//SQLException보다 IllegalArgumentException으로 에러를 더 많이 던짐!
	}
}
