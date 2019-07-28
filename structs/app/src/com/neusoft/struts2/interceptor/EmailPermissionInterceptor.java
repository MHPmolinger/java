package com.neusoft.struts2.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class EmailPermissionInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName=invocation.getProxy().getActionName();
		String methodName=invocation.getProxy().getMethod();
		String namespace=invocation.getProxy().getNamespace();
		System.out.println("actionName="+actionName+" ,method="+methodName);
		if("login".equals(methodName)){
			return invocation.invoke();//表示放行
		}else{
			//获取session
			HttpSession session=ServletActionContext.getRequest().getSession();
			if(session.getAttribute("email")!=null){
				return invocation.invoke();
			}else{
				ServletActionContext.getRequest().setAttribute("login", "请先登录！");
				return "login";
			}
			  
		}
		
	}

}
