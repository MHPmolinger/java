package com.neusoft.spring.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.spring.domain.Employee;
  //<bean id="employeeDao class="com.neusoft.spring.dao.EmployeeDao" />
@Repository(value="employeeDao")
public class EmployeeDao implements EmployeeDaoI{

	public void save(Employee emp){
		System.out.println("��["+emp.getName()+"]�־û������ݿ���");
	}
	

}
