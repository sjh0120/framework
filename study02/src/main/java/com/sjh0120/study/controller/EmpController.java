package com.sjh0120.study.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjh0120.study.model.EmpDao;
import com.sjh0120.study.model.EmpVo;

@org.springframework.stereotype.Controller
@RequestMapping("/emp/")
public class EmpController  {

	@Autowired
	EmpDao<EmpVo> empDao;
	
	@RequestMapping("list")
	public void list(Model model) throws SQLException {
		model.addAttribute("list",empDao.findAll());
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public void add() {}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String insert(@RequestParam("empno") int empno, String ename, int sal, String job) throws SQLException {
		empDao.insertOne(new EmpVo(empno,sal,ename,job));
		return "redirect:list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(@RequestParam("idx") int empno, Model model) throws SQLException{
		model.addAttribute("readonly","readonly");
		model.addAttribute("display_reset", "hidden");
		model.addAttribute("action", "edit");
		model.addAttribute("method", "get");
		model.addAttribute("bean",empDao.findOne(empno));
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void delete(int empno,HttpServletResponse res) throws SQLException {
		try {
			empDao.deleteOne(empno);
			res.setStatus(HttpServletResponse.SC_OK);
		}catch(SQLException e){
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
