package com.bit.sts26.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

	private int sabun,pay;
	private String ename;
	private Timestamp nalja;
}
