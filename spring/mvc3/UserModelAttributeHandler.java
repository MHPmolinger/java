package com.neusoft.springmvc.web.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.springmvc.domain.Address;
import com.neusoft.springmvc.domain.User;

@Controller

public class UserModelAttributeHandler {

	@ModelAttribute
	public void init(Map<String,Object> map){
		System.out.println("---init()----");
		User user=new User();
		user.setName("张三");
		Address address=new Address();
		address.setCity("南京");
		user.setAddress(address);
		map.put("user1", user);
	}
	
	@RequestMapping("/test1")
	public String test1(){
		System.out.println("test1------");
		return "info";
	}
	@RequestMapping("/test2")
	public String test2(){
		System.out.println("test2------");
		return "info";
	}
	@RequestMapping("/add")
	public String add(@ModelAttribute(value="user1")User user,Map<String,Object> map){
		System.out.println("name="+user.getName()+",city="+user.getAddress().getCity());
		map.put("u", user);
		return "info";
	}
}
