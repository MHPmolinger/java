package com.neusoft.springmvc.web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/springmvc")
public class HelloWorldHandler {

	@RequestMapping("/hello")
	public String testHello(){
		System.out.println("springmvc¿ò¼Ü´î½¨³É¹¦£¡");
		return "success";
	}
}
