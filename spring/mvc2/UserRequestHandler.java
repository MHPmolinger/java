package com.nuesoft.springmvc.web.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.nuesoft.springmvc.dao.UserDao;
import com.nuesoft.springmvc.domain.User;

public class UserRequestHandler implements HttpRequestHandler {

	private UserDao udao;
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
             List<User> list=udao.findAll();
             request.setAttribute("users", list);
             request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	}
	public UserDao getUdao() {
		return udao;
	}
	public void setUdao(UserDao udao) {
		this.udao = udao;
	}

	
}
