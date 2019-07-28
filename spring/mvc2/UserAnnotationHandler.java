package com.nuesoft.springmvc.web.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuesoft.springmvc.dao.UserDao;
import com.nuesoft.springmvc.domain.User;

@Controller
@RequestMapping(value={"/user"})
public class UserAnnotationHandler {

	@Autowired//按照类型来进行装配（DI依赖注入）
	private UserDao userDao;
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addUI(){
		System.out.println("-----ADDUI----");
		
		return "user/add";
		
	}
	@RequestMapping( value="/add",method=RequestMethod.POST)
	public String add(User user,Map<String,Object> map){
		boolean result=userDao.save(user);
		map.put("info", result?"添加用户成功！":"添加用户失败!");
		return "user/success";
	}
	//params属性的作用是用来设置请求所携带的参数名称的
	@RequestMapping(value="/test",params={"name!=lxm","age"})
	public String testParam(){
		System.out.println("test-----");
		return "user/test";
	}
	@RequestMapping(value="/test2/**/test?")
	public String test2(){
		System.out.println("--------------");
		return "user/test";
	}
}
