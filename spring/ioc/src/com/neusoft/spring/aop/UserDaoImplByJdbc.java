package com.neusoft.spring.aop;

import com.neusoft.spring.domain.User;

public class UserDaoImplByJdbc implements UserDao {

	@Override
	public void save(User user) {
		System.out.println(user.getName()+"被持久化了");

	}

	@Override
	public void update(User user) {
		System.out.println(user.getName()+"被修改了");
		
	}

	@Override
	public void delete(String name) {
		System.out.println(name+"被删除了了");
		
	}

	@Override
	public void findUser(String name) {
		System.out.println("查找到了"+name);
		
	}

}
