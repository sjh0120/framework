package com.bit.sts32.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.addFilter(null); // => 필터등록
//		http.cors().
		http.authorizeHttpRequests().antMatchers("/","/login","/logout").permitAll();
//		http.authorizeHttpRequests().antMatchers("/hello").authenticated();
//		http.authorizeHttpRequests().antMatchers("/api/emp/**").authenticated();
		http.authorizeHttpRequests().anyRequest().authenticated();
//		http.authorizeHttpRequests().anyRequest().hasAnyRole("ADMIN","USER");
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll();
		http.logout().permitAll();
		http.userDetailsService(userDetailsService);
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////
	
//	@Autowired
//	DataSource dataSource;

	//insert into users (username, password, enabled) values (?,?,?)
	//users 테이블 생성
	
	//insert into authorities (username, authority) values (?,?)
	//authorities 테이블 생성
	
//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//	  builder.jdbcAuthentication().dataSource(dataSource).withUser("user01")
//	    .password(getPasswordEncoder().encode("1234")).roles("USER");
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username,password,enabled from users where username=?")
//			.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
//			;
//	}
	///////////////////////////////////////////////////////////////////
}
