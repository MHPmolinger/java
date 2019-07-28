package com.nuesoft.springmvc.web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestMethodResultHandler {

	@RequestMapping(value="/void")
	public void test1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 response.setContentType("text/html;charset=utf-8");
		 request.setAttribute("name", "zhangsan");
		 request.getSession().setAttribute("name", "session_name");
		 request.getServletContext().setAttribute("name", "application_name");
		request.getRequestDispatcher("/WEB-INF/jsp/test/info.jsp").forward(request, response);
	}
	@RequestMapping(value="/mv")
	public ModelAndView test2(){
		ModelAndView mv=new ModelAndView();
		   mv.addObject("name", "modelAndView_name");
		   mv.setViewName("test/info");
		return mv;
	}
	@RequestMapping("/str")
	public String test3(){
		System.out.println("------return string------");
		return "test/info";
	}
	@RequestMapping(value="/forward")
	public String test4(){
		
		return "forward:/user/add";
	}
	@RequestMapping(value="/redirect")
	public String test5(){
		
		return "redirect:/user/add";
	}
}
