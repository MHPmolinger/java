package com.nuesoft.springmvc.dao;
import java.util.*;

import com.nuesoft.springmvc.domain.User;

import java.sql.*;
public class UserDao {

	public List<User> findAll(){
		List<User> users=new ArrayList<User>();
		for(int i=1;i<=20;i++){
			String pwd="";
			while(true){
				pwd=""+(int)(Math.random()*987654321);
				if(pwd.length()>=6){
					pwd=pwd.substring(pwd.length()-6);
					break;
				}
			}
			users.add(new User("name-"+i,pwd));
		}
		return users;
	}
	
	public boolean save(User user){
		boolean result=false;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql="insert into user(name,password)values(?,?)";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc", "root", "root");
			if(con!=null){
				ps=con.prepareStatement(sql);
				ps.setString(1,user.getName());
				ps.setString(2,user.getPassword());
				result=ps.executeUpdate()>0?true:false;
				ps.close();
				 con.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
