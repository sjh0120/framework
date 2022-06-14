package com.bit.sts11;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts11.model.DeptDao;


@Controller
public class HomeController {
	
	@Autowired
	DeptDao deptDao;
	
//	@Autowired
//	SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws SQLException {
//		model.addAttribute("list",sqlSession.getMapper(DeptDao.class).findAll());
		model.addAttribute("list",deptDao.findAll());
		return "home";
	}
	
}
