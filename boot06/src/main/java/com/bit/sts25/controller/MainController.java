package com.bit.sts25.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts25.domain.Emp;
import com.bit.sts25.service.EmpServiceImpl;

@RestController
public class MainController {

	@Autowired
	EmpServiceImpl empService;
	
	@GetMapping("/")
	public String index() {
		return "API Service는 담당자에게 문의하세요";
	}
	
	@GetMapping("/api/emp")
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(empService.getList());
		
	}
	
	@PostMapping("/api/emp")
	public ResponseEntity<?> add(@RequestBody Emp emp){
		Map<String,Object> map = new LinkedHashMap<>();
		if(empService.addList(emp)!=null) {
			map.put("result", true);
			map.put("emp", emp);
			return ResponseEntity.ok(map);
		}
		map.put("result", false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		
	}
}
