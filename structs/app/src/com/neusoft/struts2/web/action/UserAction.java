package com.neusoft.struts2.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.neusoft.struts2.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private User user;
    private String userName;
    private Date birthday;
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String add(){
		return "add";
	}
	
	public String update(){
		System.out.println("update-----------");
		return "update";
	}
	
	public String addUser(){
		System.out.println("username:"+userName+",birthday="+birthday);
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=new User();
		user.setName("zhangsan");
		user.setPassword("123456");
		request.setAttribute("user", user);
		return "addUser";
	}
	public String find(){
		
		return "find";
	}
}
