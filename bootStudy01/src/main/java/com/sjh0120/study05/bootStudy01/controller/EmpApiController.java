package com.sjh0120.study05.bootStudy01.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjh0120.study05.bootStudy01.mapper.domain.Emp;
import com.sjh0120.study05.bootStudy01.service.EmpImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmpApiController {

	@Autowired
	EmpImpl empImpl;
	
	@GetMapping("/emp")
	public ResponseEntity<?> getList(){
		return ResponseEntity.ok(empImpl.selectAll());
	}
	
	@GetMapping("/emp/{empno}")
	public ResponseEntity<?> getEmp(@PathVariable int empno){
		return ResponseEntity.ok(empImpl.selectOne(empno));
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmp(@RequestBody Emp bean){
		Map<String,Object> map=new LinkedHashMap<>();
		if(empImpl.insertOne(bean)>0) {
			map.put("result", true);
			return ResponseEntity.ok(map);
		}
		map.put("result", false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);	
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<?> updateEmp(@RequestBody Emp bean){
		Map<String,Object> map=new LinkedHashMap<>();
		if(empImpl.updateOne(bean)>0) {
			map.put("result", true);
			return ResponseEntity.ok(map);
		}
		map.put("result", false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@DeleteMapping("/emp/{empno}")
	public ResponseEntity<?> deleteEmp(@PathVariable int empno){
		Map<String,Object> map=new LinkedHashMap<>();
		if(empImpl.deleteOne(empno)>0) {
			map.put("result", true);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		map.put("result",false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
}
