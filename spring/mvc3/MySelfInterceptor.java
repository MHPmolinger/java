package com.neusoft.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MySelfInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("MySelfInterceptor.afterCompletion========-----被最后调用了");
		System.out.println("object="+object+",exception="+exception);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView mv) throws Exception {
		System.out.println("MySelfInterceptor.postHandle+++++++++-----被后调用了");
		System.out.println("viewName="+mv.getViewName()+",ModelAndView.getClass()="+mv.getClass());
		System.out.println("Object="+object);
		System.out.println("modle="+mv.getModel().get("name"));

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		System.out.println("MySelfInterceptor.preHandle-----被先调用了");
		System.out.println(object);
		return true;
	}

}
