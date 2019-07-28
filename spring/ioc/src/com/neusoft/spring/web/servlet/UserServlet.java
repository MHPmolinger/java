package com.neusoft.spring.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.neusoft.spring.domain.Employee;
import com.neusoft.spring.service.EmployeeService;
@WebServlet("/addEmp")
public class UserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		   EmployeeService es=(EmployeeService) context.getBean("employeeService");
		   Employee emp=new Employee();
		   emp.setName(request.getParameter("name"));
		   es.addEmployee(emp);
		   request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
	}

	
	
}
