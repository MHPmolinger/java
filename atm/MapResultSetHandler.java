package com.neusoft.atm.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.atm.dao.ResultSetHandler;

public class MapResultSetHandler implements ResultSetHandler {
   
	public MapResultSetHandler(){
		
	}
	@Override
	public Object handler(ResultSet rs) {
		   Map<String,Object> map=new HashMap<String,Object>();
		//获取结果集的元数据信息
		try {
			ResultSetMetaData rsmd=rs.getMetaData();
			int columns=rsmd.getColumnCount();
			if(rs.next()){
				for(int i=1;i<=columns;i++){
					//获取列的名称
					String columnName=rsmd.getColumnName(i);
					Object columnValue=rs.getObject(columnName);
					map.put(columnName, columnValue);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}

}
