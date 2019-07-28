package com.neusoft.atm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanFactory {

	private BeanFactory(){}
	private static Map<String,String> beans=new HashMap<String,String>();
	static{
		InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			Enumeration<String> keys=(Enumeration<String>) prop.propertyNames();
			while(keys.hasMoreElements()){
				String key=keys.nextElement();
				String value=prop.getProperty(key);
				beans.put(key, value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args){
		Set<String> keys=beans.keySet();
		for(String key:keys){
			String value=beans.get(key);
			System.out.println(key+"::"+value);
		}
	}
	public static  <T> T getBean(Class<T> clazz){
		T t =null;
		String className=clazz.getSimpleName();
		//用该类名到配置文件中找对应匹配的key
		Set<String> keys=beans.keySet();
		for(String key:keys){
			if(key.equalsIgnoreCase(className)){
				//获取对应的value值
				String value=beans.get(key);
				//System.out.println("value="+value);
				//通过类的完整路径来创建该类的对像 并赋值给t
				try {
					Class targetClass=Class.forName(value);
					
					//有了目标类的二进制字节码文件对象就可以使用Class类中的newInstance()方法来获得该对象，底层是通过反射来实现的
					t=(T) targetClass.newInstance();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		return t;
		
	}
}
