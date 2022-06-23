package com.bit.sts251.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

	private int sabutn,pay;
	private String ename;
	private Date nalja;
}
