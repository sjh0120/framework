package com.sjh0120.study04.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sjh0120.study04.model.EmpDao;

@Controller
public class HomeController {
	
	@Autowired
	EmpDao empDao;
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/emp")
	public String emp(Model model) throws SQLException{
		model.addAttribute("list",empDao.findAll());
		return "emp";
	}
	
	@GetMapping("/addemp")
	public String addemp(){
		return "addemp";
	}
	
}
