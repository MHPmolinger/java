package com.neusoft.spring.aop;
//֪ͨ��
public class Advice {

	public void beforeAdvice(){
         System.out.println("��ȫ����֤");
	}
	
	public void afterAdvice(){
		System.out.println("����־��¼");
	}
	public void exceptionAdvice(){
		System.out.println("�쳣����֪ͨ");
	}
}
