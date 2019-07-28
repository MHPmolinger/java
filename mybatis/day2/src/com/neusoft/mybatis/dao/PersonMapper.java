package com.neusoft.mybatis.dao;

import com.neusoft.mybatis.domain.Person;

public interface PersonMapper {

	public Person findById(int id);
	
	public Person findByIdcard(int idcard_id);
	
	public void save(Person p);
}
