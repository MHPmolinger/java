package com.neusoft.atm.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neusoft.atm.dao.ResultSetHandler;

public class MapListResultSetHandler implements ResultSetHandler {

	@Override
	public Object handler(ResultSet rs) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		//获取结果集的元数据信息
		try {
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String columnName=rsmd.getColumnName(i);
					Object columnValue=rs.getObject(columnName);
					map.put(columnName, columnValue);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return list;
	}

}
