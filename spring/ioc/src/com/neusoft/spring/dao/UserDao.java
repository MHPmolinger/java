package com.neusoft.spring.dao;

import com.neusoft.spring.domain.User;

public class UserDao {

	public void save(User user){
		
		System.out.println("�û�["+user.getName()+"]���־û������ݿ��ˣ�");
	}
}
