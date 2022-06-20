package com.sjh0120.study05.bootStudy01.mapper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private int empno,sal;
	private String ename, job;
}
