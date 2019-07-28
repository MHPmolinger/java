package com.neusoft.spring.aop;

import com.neusoft.spring.domain.User;

public class UserDaoImplByJdbc implements UserDao {

	@Override
	public void save(User user) {
		System.out.println(user.getName()+"���־û���");

	}

	@Override
	public void update(User user) {
		System.out.println(user.getName()+"���޸���");
		
	}

	@Override
	public void delete(String name) {
		System.out.println(name+"��ɾ������");
		
	}

	@Override
	public void findUser(String name) {
		System.out.println("���ҵ���"+name);
		
	}

}
