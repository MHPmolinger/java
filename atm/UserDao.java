package com.neusoft.atm.dao;

import java.util.List;

import com.neusoft.atm.domain.User;

public interface UserDao {

	//通过用户Id来查询一个用户
	public User findById(String id);
	//通过身份证号码来查询一个用户
	public User findByIdCard(String idcard);
	public void save(User user);
	
	public List<User> findAll();
}
