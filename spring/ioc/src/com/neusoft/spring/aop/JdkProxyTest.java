package com.neusoft.spring.aop;

import org.junit.Test;

import com.neusoft.spring.dao.EmployeeDao;
import com.neusoft.spring.dao.EmployeeDaoI;
import com.neusoft.spring.domain.Employee;
import com.neusoft.spring.domain.User;

public class JdkProxyTest {

	@Test
	public void test1(){
		 JdkProxy jdkProxy=new JdkProxy(new UserDaoImplByJdbc(),new Advice());
		 UserDao userDaoProxy=(UserDao) jdkProxy.getProxy();
		 
		 userDaoProxy.delete("张三");
		 User user=new User();
		 user.setName("张三");
		 userDaoProxy.save(user);
		 userDaoProxy.findUser(user.getName());
		 userDaoProxy.update(user);
	}
	@Test
	public void test2(){
		EmployeeDaoI dao=(EmployeeDaoI) JdkProxy.createProxy(new EmployeeDao(), new Advice());
		Employee emp=new Employee();
		emp.setName("张三");
		dao.save(emp);
	}
}
