package com.bit.st22.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.st22.domain.Dept;

@Mapper
public interface DeptDao {

	@Select("select * from dept order by deptno")
	List<Dept> findAll();
	
	@Insert("insert into dept (deptno,dname,loc) values (#{deptno}, #{dname}, #{loc})")
	int insertOne(Dept dept);
	
	@Select("select * from dept where deptno=#{num}")
	Dept findOne(int num);

	@Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
	int updateOne(Dept bean);
	
	@Delete("delete from dept where deptno=#{deptno}")
	int deleteOne(int deptno);
}
