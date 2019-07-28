package com.neusoft.springmvc.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.neusoft.springmvc.domain.User;

import java.util.*;
public class XMLHelloContrller implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("info");//�����߼���ͼ����
		 List<User> users=new ArrayList<User>();
		 for(int i=1;i<=20;i++){
			users.add(new User((""+(i<10?"0":"")+i),"name-"+i,(int)(Math.random()*100))) ;
		 }
		 mv.addObject("users", users);//��ģ�Ͷ����������������������request.setAttribute("users",users)����
		return mv;
	}

}
