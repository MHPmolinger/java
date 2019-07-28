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
		System.out.println("欢迎["+user.getName()+"]来我系统！");
		userDao.save(user);
		 for(long i=1;i<=10000;i++){
			 System.out.print(i);
		 }
		 System.out.println();
		long end=System.currentTimeMillis();
		System.out.println("用时["+(end-start)+"]毫秒");
	}
}
