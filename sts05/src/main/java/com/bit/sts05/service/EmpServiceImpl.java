package com.bit.sts05.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts05.model.EmpDao;
import com.bit.sts05.model.EmpVo;

@Transactional(rollbackFor = Exception.class)
@Service
public class EmpServiceImpl implements EmpService {
	/*
	com.bit.sts05.model이 먼저 실행되어서 EmpDao 가 존재하지만
	만약 컴퓨터의 성능이 안좋아서 EmpDao가 생성되지 않은채
	com.bit.stst05.service가 먼저 실행되어버린다면 에러가 발생할 수 있다
	즉 @Autowired가 되지 않기 때문에 에러가 발생
	따라서 @repository @service @controller를 통해서 실행의 순서를 부여한다!
	이를 통해서 @Autowired 에러를 방지할 수 있다!
	1 -> @repository
	2 -> @service
	3 -> controller
	*/
	@Autowired
	EmpDao<EmpVo> empDao;
	
	@Override
	public void selectAll(Model model) throws SQLException {
		model.addAttribute("list",empDao.findAll());
	}
	
	@Override
	public void insert(EmpVo bean) throws SQLException {
		empDao.insertOne(bean);
		bean.setEmpno(bean.getEmpno()+1);
		empDao.insertOne(bean);
		
	}
	
	
}
