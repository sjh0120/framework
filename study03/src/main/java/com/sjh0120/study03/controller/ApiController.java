package com.sjh0120.study03.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sjh0120.study03.domain.EmpDao;
import com.sjh0120.study03.domain.EmpVo;

@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
	EmpDao empDao;
	
	@RequestMapping(value="/emp",method = RequestMethod.GET)
	public void list(HttpServletResponse res) throws Exception {
		res.setContentType("application/json; charset=utf-8");
		PrintWriter out=res.getWriter();
		out.print("{\"root\":[");
		boolean tf=true;
		for (EmpVo bean : empDao.findAll()) {
			if(tf) {
				tf=false;
			}else {
				out.print(",");
			}
			out.print("{\"empno\":"+bean.getEmpno()+",\"ename\":\""
					+bean.getEname()+"\",\"sal\":"+bean.getSal()+",\"job\":\""+bean.getJob()+"\"}");
		}
		out.print("]}");
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public void add(HttpServletResponse res,@ModelAttribute EmpVo bean) throws Exception {
		empDao.insertOne(bean);
		//res.setStatus(HttpServletResponse.SC_OK);
	}
}
