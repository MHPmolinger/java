package com.neusoft.spring.aop;
//通知类
public class Advice {

	public void beforeAdvice(){
         System.out.println("做全局验证");
	}
	
	public void afterAdvice(){
		System.out.println("做日志记录");
	}
	public void exceptionAdvice(){
		System.out.println("异常处理通知");
	}
}
