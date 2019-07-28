package cn.neusoft.usermanager.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

	private WebUtils(){}
	
	public static String stringArray2String(String[] array){
		StringBuilder sb=new StringBuilder();
		for(int i=0;array!=null&&i<array.length;i++){
			sb.append(array[i]);
			if(i<array.length-1){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public  static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		T t=null;
		try {
			t=clazz.newInstance();
			Field[] fields=clazz.getDeclaredFields();
			//获取表单中的所有参数
			Enumeration<String> names=request.getParameterNames();
			while(names.hasMoreElements()){
				//<Input type="text" name="name" />张三，paramName="NAME",paramVlaue="张三"
				String paramName=names.nextElement();
				String paramValue=stringArray2String(request.getParameterValues(paramName));
				//查询clazz对应的属性进行匹配
				for(Field f:fields){
					String fname=f.getName();//name,gender,birthday....
					if(fname.equalsIgnoreCase(paramName)){
						//把字段设置为可见（因为有可能是私有的）
						f.setAccessible(true);
						//添加类型转换的代码,例如日期类型的，还有boolean类型等等
						if(f.getType()==java.util.Date.class){
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							try {
								Date date=sdf.parse(paramValue);
								f.set(t, date);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(f.getType()==Integer.class||f.getType()==int.class){
							f.set(t, Integer.parseInt(paramValue));
						}else if(f.getType()==Double.class||f.getType()==double.class){
							f.set(t, Double.parseDouble(paramValue));
						}else if(f.getType()==Float.class||f.getType()==float.class){
							f.set(t, Float.parseFloat(paramValue));
						}else if(f.getType()==Boolean.class||f.getType()==boolean.class){
							f.set(t, Boolean.parseBoolean(paramValue));
						}else if(f.getType()==String.class){
							f.set(t, paramValue);
						}
						
						break;
						
					}
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
