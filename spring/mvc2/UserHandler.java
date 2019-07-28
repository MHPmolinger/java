package com.nuesoft.springmvc.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nuesoft.springmvc.dao.UserDao;
import com.nuesoft.springmvc.domain.User;

public class UserHandler implements Controller {

	private UserDao userDao;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> list=userDao.findAll();
		ModelAndView mv=new ModelAndView("success");
		//mv.setViewName("success");
		System.out.println("---------------");
		mv.addObject("users", list);
		return mv;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
