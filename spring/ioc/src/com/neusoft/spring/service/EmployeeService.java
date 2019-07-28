package com.neusoft.spring.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.neusoft.spring.dao.EmployeeDao;
import com.neusoft.spring.domain.Employee;
@Service(value="employeeService")
@Scope(value="singleton")
public class EmployeeService {

	 @Resource(name="employeeDao")
	  private EmployeeDao empDao;
	
	public void addEmployee(Employee emp){
		empDao.save(emp);
	}
}
