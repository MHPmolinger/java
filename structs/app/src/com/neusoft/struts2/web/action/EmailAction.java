package com.neusoft.struts2.web.action;

import org.apache.struts2.ServletActionContext;

import com.neusoft.struts2.domain.Email;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmailAction extends ActionSupport implements ModelDriven<Email> {

	    private Email email=new Email();
	public String login(){
		System.out.println(email.getEmailName()+",pwd="+email.getLoginPwd());
		   if("admin".equalsIgnoreCase(email.getEmailName())&&"123456".equalsIgnoreCase(email.getLoginPwd())){
			    ServletActionContext.getRequest().getSession().setAttribute("email", email);
			   return "index";
		   }else{
			     ServletActionContext.getRequest().setAttribute("error", "用户名或密码错误！");
			   return "error";
		   }
		
	
		
	}
	
	public String send(){
		
		return "send";
	}
	@Override
	public Email getModel() {
		// TODO Auto-generated method stub
		return email;
	}
}
