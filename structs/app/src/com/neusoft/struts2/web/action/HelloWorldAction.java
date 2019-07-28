package com.neusoft.struts2.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("HelloWorldAction被调用了");
		return "success";
	}

	
}
