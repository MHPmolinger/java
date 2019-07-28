package com.neusoft.spring.dao;

import com.neusoft.spring.domain.User;

public class UserDao {

	public void save(User user){
		
		System.out.println("用户["+user.getName()+"]被持久化到数据库了！");
	}
}
