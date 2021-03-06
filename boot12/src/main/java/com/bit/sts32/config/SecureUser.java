package com.bit.sts32.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.bit.sts32.domain.LoginUser;

import lombok.Data;

@Data
public class SecureUser extends User {
	private LoginUser loginUser;
	
	public SecureUser(LoginUser bean){
		super(bean.getUsername(), bean.getPassword(), AuthorityUtils.createAuthorityList(bean.getAuthority()));
		loginUser=bean;
	}
}
