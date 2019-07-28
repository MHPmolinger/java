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
			//��ȡ���е����в���
			Enumeration<String> names=request.getParameterNames();
			while(names.hasMoreElements()){
				//<Input type="text" name="name" />������paramName="NAME",paramVlaue="����"
				String paramName=names.nextElement();
				String paramValue=stringArray2String(request.getParameterValues(paramName));
				//��ѯclazz��Ӧ�����Խ���ƥ��
				for(Field f:fields){
					String fname=f.getName();//name,gender,birthday....
					if(fname.equalsIgnoreCase(paramName)){
						//���ֶ�����Ϊ�ɼ�����Ϊ�п�����˽�еģ�
						f.setAccessible(true);
						//�������ת���Ĵ���,�����������͵ģ�����boolean���͵ȵ�
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
