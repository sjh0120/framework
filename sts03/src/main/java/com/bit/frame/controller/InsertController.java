package com.bit.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.frame.model.EmpDao;
import com.bit.frame.model.EmpVo;

public class InsertController extends AbstractCommandController {
	@Autowired
	EmpDao<EmpVo> empDao;
		
   @Override
   protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
         BindException errors) throws Exception {
      System.out.println(errors.hasErrors());
      //if를 통해 에러유무 확인 -> 에러 있으면 add페이지로 이동 및 에러 코드 출력
      //onBindAndValidate에서 addError을 했기 때문에 에러코드를 뽑아낼 수 있음!
	  EmpVo bean=(EmpVo)command;
      empDao.insertOne(bean);
      return new ModelAndView("redirect:list");
   }

   @Override
protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
		throws Exception {
	   EmpVo bean=(EmpVo)command;
	   if(bean.getEname().isEmpty()) {
		   ObjectError error=new ObjectError("ename", "이름이 비었음");
		   errors.addError(error);
	   }
	   
	   System.out.println(errors);
   }
}