package com.neusoft.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class JdkProxy {

	private Object target;//Ŀ����
	private Advice advice;//֪ͨ
	public JdkProxy(Object target,Advice advice){
		this.target=target;
		this.advice=advice;
	}
	
	public JdkProxy(){
		
	}
	public Object getProxy(){
	
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), 
				     this.target.getClass().getInterfaces(), 
				     new InvocationHandler(){

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							//֯���Ӧ��֪ͨ
							JdkProxy.this.advice.beforeAdvice();
							//ִ��Ŀ�귽��
							Object result=method.invoke(target, args);
							advice.afterAdvice();
							return result;
						}
			
		});
	}	
		public static Object createProxy(final Object target,final Advice advice){
			return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
					  target.getClass().getInterfaces(),
					  new InvocationHandler(){

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							  advice.beforeAdvice();
							  Object result=method.invoke(target, args);
							  advice.afterAdvice();
							return result;
						}
				
			});
			
		}
	
}
