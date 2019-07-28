package com.neusoft.spring.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.spring.dao.AccountDao;
import com.neusoft.spring.dao.EmployeeDao;
import com.neusoft.spring.domain.Account;
import com.neusoft.spring.domain.Employee;

public class JdbcTemplateTest {

	@Test
	public void test1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");
		Employee emp=new Employee();
		emp.setEmpId("10003");
		emp.setName("ÕıŒÂ");
		emp.setHireDate(new Date());
		emp.setSalary(10000);
		empDao.save(emp);
	}
	@Test
	public void test2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");
		Employee emp=empDao.findById("10001");
		System.out.println(emp);
	}
	@Test
	public void test3(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");
		List<Employee> list=empDao.findAll();
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	@Test
	public void test4(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");
		List<Employee> list=empDao.findByName("%¿Ó%");
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void test5(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");
		System.out.println(empDao.totalRecords());
	}
	
	@Test
	public void test6(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=(AccountDao) context.getBean("accountDao");
		Account from=accountDao.findById("888888");
		Account to=accountDao.findById("999999");
		accountDao.tranfer(from, to, 500);
		
	}
}
