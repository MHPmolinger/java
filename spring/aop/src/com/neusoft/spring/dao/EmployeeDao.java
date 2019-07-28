package com.neusoft.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.neusoft.spring.domain.Employee;
@Repository("employeeDao")
public class EmployeeDao {

	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	
	  
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void save(Employee emp){
		String sql="insert into employee(empid,name,hireDate,salary) values(?,?,?,?)";
		jdbcTemplate.update(sql, emp.getEmpId(),emp.getName(),emp.getHireDate(),emp.getSalary());
	}
	
	public Employee findById(String empId){
		String sql="select * from employee where empId=?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper,empId);
	}
	
	public List<Employee> findAll(){
		String sql="select * from employee ";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Employee> findByName(String name){
		String sql="select * from employee where name like ?";
		return this.jdbcTemplate.query(sql, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp=new Employee();
				//做列到属性的封装操作
				emp.setEmpId(rs.getString("empId"));
				emp.setName(rs.getString("name"));
				emp.setHireDate(rs.getDate("hireDate"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}
			
		}, name);
	}
	
	public int totalRecords(){
		String sql="select count(*) from employee";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
