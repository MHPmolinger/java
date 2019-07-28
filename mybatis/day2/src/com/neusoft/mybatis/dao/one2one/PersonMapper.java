package com.neusoft.mybatis.dao.one2one;

import java.util.List;

import com.neusoft.mybatis.one2one.domain.Person;

public interface PersonMapper {

	public  void save(Person p);
	
	public Person findById(int pid);
	
	public Person findByCid(int cid);
	
	public List<Person> findAll();
	
	public List<Person> findByName(String name);
}
