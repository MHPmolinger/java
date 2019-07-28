package com.neusoft.spring.web.servlet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.spring.dao.UserDao;
import com.neusoft.spring.domain.Employee;
import com.neusoft.spring.domain.User;
import com.neusoft.spring.service.EmployeeService;
import com.neusoft.spring.service.UserService;

public class TestIoc {

	@Test
	public void testIoc(){
		UserService us=new UserService();//手动的创建对象及维护其声明周期
		User user=new User();//手动的创建对象及维护其声明周期
		user.setName("张三");
		user.setAge(20);
		UserDao userDao=new UserDao();//手动的创建对象及维护其声明周期
		us.setUserDao(userDao);//依赖对象的注入（DI)
		us.register(user);
	}
	
	@Test
	public void test2(){
		//获取Spring容器对象
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User) context.getBean("user");
		UserService us=(UserService) context.getBean("userService");
		us.register(user);
	}
	@Test
	public void test3(){
		//获取Spring容器对象
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user1=(User) context.getBean("user2");
		System.out.println(user1);
		User user2=(User) context.getBean("user2");
		System.out.println(user1==user2);
		
	}
	
	@Test
	public void test4(){
		//获取Spring容器对象
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User) context.getBean("user3");
		System.out.println(user);
		UserService us=(UserService) context.getBean("userService2");
		us.register(user);
		
	}
	@Test
	public void test5(){
		//获取Spring容器对象
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User) context.getBean("user");
		System.out.println(user);
		
		
	}
	@Test
	public void test6(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService es=(EmployeeService) context.getBean("employeeService");
		Employee emp=(Employee) context.getBean("emp");
		es.addEmployee(emp);
	}
}
