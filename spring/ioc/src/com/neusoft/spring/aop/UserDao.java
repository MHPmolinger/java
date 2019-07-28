package com.neusoft.spring.aop;

import com.neusoft.spring.domain.User;

public interface UserDao {

	public void save(User user);
	
	public void update(User user);
	
	public void delete(String user);
	
	public void findUser(String name);
}
