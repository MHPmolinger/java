package com.neusoft.spring.service;

import com.neusoft.spring.dao.UserDao;
import com.neusoft.spring.domain.User;

public class UserService {
       private UserDao userDao;
       
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void register(User user){
		long start=System.currentTimeMillis();
		System.out.println("��ӭ["+user.getName()+"]����ϵͳ��");
		userDao.save(user);
		 for(long i=1;i<=10000;i++){
			 System.out.print(i);
		 }
		 System.out.println();
		long end=System.currentTimeMillis();
		System.out.println("��ʱ["+(end-start)+"]����");
	}
}