package com.neusoft.atm.dao.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.neusoft.atm.dao.ResultSetHandler;
/**
 * 类的作用：查询一个实体对象的，负责将一条查询上来的记录封装到一个实体对象上来
 * @author neusoft102
 *
 */
public class BeanResultSetHandler implements ResultSetHandler {

	   private Class clazz;
	   public BeanResultSetHandler(Class clazz){
		   this.clazz=clazz;
	   }
	@Override
	public Object handler(ResultSet rs) {
		Object bean=null;
		try {
			if(rs.next()){
				bean=this.clazz.newInstance();
				ResultSetMetaData rsmd=rs.getMetaData();
				//获取查询结果集中有多少列
				int totalColumns=rsmd.getColumnCount();
				//获取该类对应的属性
				Field[] fields=this.clazz.getDeclaredFields();
				//遍历该属性的数组
				for(Field f:fields){
					//获取属性的名称
					String paramName=f.getName();
					//到查询结果集中去匹配列名称
					for(int i=1;i<=totalColumns;i++){
						//获取到列名称
						String columnName=rsmd.getColumnName(i);
						if(columnName.equalsIgnoreCase(paramName)){
							//表示匹配上了,我们需要把该列的值设置到实体对象的对应f属性上来
							//获取到对应的列的值
							Object columnValue=rs.getObject(columnName);
							f.setAccessible(true);//要把私有属性设置为可见
							if(f.getType() ==java.lang.Boolean.class||f.getType()==boolean.class){
								int n=(int)columnValue;
								f.set(bean, n==1?true:false);
							}else if(f.getType()==Double.class||f.getType()==double.class){
								BigDecimal bd=(BigDecimal)columnValue;
								f.set(bean, bd.doubleValue());
							}else if(f.getType()==Float.class||f.getType()==float.class){
								BigDecimal bd=(BigDecimal)columnValue;
								f.set(bean, bd.floatValue());
							}else{
								f.set(bean, columnValue);//把columnValue列的值设置到实体对象bean的属性f上来
							}
							
							break;
						}
					}
					
				}
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return bean;
	}

}
