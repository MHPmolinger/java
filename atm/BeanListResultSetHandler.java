package com.neusoft.atm.dao.impl;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neusoft.atm.dao.ResultSetHandler;

public class BeanListResultSetHandler implements ResultSetHandler {

	private Class clazz;
	public BeanListResultSetHandler(Class clazz){
		this.clazz=clazz;
	}
	
	@Override
	public Object handler(ResultSet rs) {
		List<Object> list=new ArrayList();
		try {
			ResultSetMetaData rsmd=rs.getMetaData();
			int tolalColumns=rsmd.getColumnCount();
			Object bean=null;
			while(rs.next()){
				bean=this.clazz.newInstance();
				//获取类中的所有属性
				Field[] fields=this.clazz.getDeclaredFields();
				for(Field f:fields){
					String paramName=f.getName();//获得属性的名称
					for(int i=1;i<=tolalColumns;i++){
						//获取表中列的名称
						String columnName=rsmd.getColumnName(i);
						if(columnName.equalsIgnoreCase(paramName)){
							//获取对应列的值
							f.setAccessible(true);
							if(f.getType()==java.lang.Double.class||f.getType()==double.class){
								f.set(bean, rs.getDouble(columnName));
							}else if(f.getType()==float.class||f.getType()==Float.class){
								f.set(bean, rs.getFloat(columnName));
							}else if(f.getType()==boolean.class||f.getType()==Boolean.class){
								f.set(bean, rs.getInt(columnName)==1?true:false);
							}else if(f.getType()==Date.class){
								f.set(bean, rs.getDate(columnName));
							}else if(f.getType()==Long.class||f.getType()==long.class){
								f.set(bean, rs.getLong(columnName));
							}else if(f.getType()==Integer.class||f.getType()==int.class){
								f.set(bean, rs.getInt(columnName));
							}else{
								f.set(bean, rs.getObject(columnName));
							}
							break;
						}
						
					}
				}
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
