package com.sjh0120.study04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo {
	private int empno,sal;
	private String ename,job;
}
