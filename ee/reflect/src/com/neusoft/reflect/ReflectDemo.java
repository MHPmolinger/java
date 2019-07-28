package com.neusoft.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ReflectDemo {

	@Test
	public void testFiled() throws ClassNotFoundException{
		//获取类对应的二进制字节码对象
		Class clazz=Student.class;
		Class clazz2=Class.forName("com.neusoft.reflect.Student");
		Class clazz3=new Student().getClass();
		System.out.println(clazz==clazz2);
		System.out.println(clazz==clazz3);
		//获取该类中的所有属性
		Field[] fields=clazz.getDeclaredFields();
		//遍历所有的属性
		for(Field f:fields){
			//获取属性的名称
			String fName=f.getName();
			//获取属性的类型
			String fType=f.getType().getSimpleName();
			//获取属性的修饰符
			String fModify=Modifier.toString(f.getModifiers());
			System.out.println(fModify+" "+fType+"　"+fName);
		}
		
	}
	
    @Test
     public void testMethod(){
    	Class clazz=Student.class;
    	Method[] methods=clazz.getDeclaredMethods();
    	for(Method m:methods){
    		//获取方法的名称
    		String methodName=m.getName();
    		//获取方法的返回值类型
    		String methodReturnType=m.getReturnType().getSimpleName();
    		//获取方法的修饰符
    		String methodModify=Modifier.toString( m.getModifiers());
    		//获取方法的参数列表
    		Class[] paramTypes=m.getParameterTypes();
    		//把参数拼凑为一个字符串，彼此之间用逗号隔开
    		//String ,StringBuffer,StringBuilder三者的区别
    		StringBuilder sb=new StringBuilder();
    		sb.append("(");
    		if(paramTypes!=null&&paramTypes.length>0){
    			for(int i=0;i<paramTypes.length;i++){
    				sb.append(paramTypes[i].getSimpleName());
    				sb.append("  param-"+i);
    				if(i<paramTypes.length-1){
    					sb.append(", ");
    				}
    				
    			}
    		}
    		
    		sb.append(")");
    		System.out.println(methodModify+"　"+methodReturnType+" "+methodName+sb.toString());
    	}
    }
    
    @Test
    public void test3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Student stu=new Student();
    	Class clazz=stu.getClass();
    	Field f=clazz.getDeclaredField("name");
    	//因为有可能该属性是私有的，我们要把私有设置为可见 
    	f.setAccessible(true);//把该属性设置为可见 这样我们才可以对该属性进行操作
    	f.set(stu, "张三");//该对象stu的属性f设置一个值为张三
    	String value=(String) f.get(stu);
    	System.out.println(value);
    	
    }
    @Test
    public void test4() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	Student stu=new Student();
    	stu.setName("李四");
    	Method m=Student.class.getDeclaredMethod("sayHello",String.class,int.class);
    	m.invoke(stu,"王五",20);
    }
}
