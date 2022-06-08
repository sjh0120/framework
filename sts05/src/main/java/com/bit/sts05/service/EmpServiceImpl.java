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
	com.bit.sts05.model�� ���� ����Ǿ EmpDao �� ����������
	���� ��ǻ���� ������ �����Ƽ� EmpDao�� �������� ����ä
	com.bit.stst05.service�� ���� ����Ǿ�����ٸ� ������ �߻��� �� �ִ�
	�� @Autowired�� ���� �ʱ� ������ ������ �߻�
	���� @repository @service @controller�� ���ؼ� ������ ������ �ο��Ѵ�!
	�̸� ���ؼ� @Autowired ������ ������ �� �ִ�!
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
