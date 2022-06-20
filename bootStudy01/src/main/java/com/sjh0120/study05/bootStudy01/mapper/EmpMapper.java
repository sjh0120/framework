package com.sjh0120.study05.bootStudy01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sjh0120.study05.bootStudy01.mapper.domain.Emp;

@Mapper
public interface EmpMapper {
	
	
	@Select("select * from emp")
	List<Emp> findAll();
	
	@Select("select * from emp where empno=#{empno}")
	Emp findOne(int empno);
	
	@Insert("insert into emp (empno,ename,job,sal) values (#{empno}, #{ename}, #{job}, #{sal})")
	int insertOne(Emp bean);
	
	@Update("update set ename=#{ename}, job=#{job}, sal=#{sal} where empno=#{empno}")
	int updateOne(Emp bean);
	
	@Delete("delete from emp where empno=#{empno}")
	int deleteOne(int empno);
	
}
