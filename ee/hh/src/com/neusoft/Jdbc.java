package com.neusoft;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Jdbc {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/java1";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection con;
	private static Statement sta;
	static {
		try {
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		if (con == null) {
			try {
				con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}

	public Statement getSta() {
		if (sta == null) {
			try {
				sta = (Statement) getConn().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sta;
	}

	public void closeSta(Statement sta) {
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeCon(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addStudent(Student s) {
		String sql = "insert into student1 values('" + s.getName() + "','" + s.getAge() + "','" + s.getGender() + "')";
		try {
			getSta().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSta(sta);
			closeCon(con);
		}
	}

	public void deleteByName(String name) {

	}

	public Student queryByName(String name) {
		String sql = "select * from student1 where name ='"+name+"'";
		Student s = new Student();
		try {
			ResultSet rs = getSta().executeQuery(sql);
			if (rs.next()) {
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeSta(sta);
			closeCon(con);
		}

		return s;
	}

	public static void main(String[] args) {
		//Student s=new Student("ÕÅ·É", 34, "ÄÐ");
		Jdbc obj = new Jdbc();
		//obj.addStudent(s);
		
		Student s=obj.queryByName("ÕÅ·É");
		System.out.println(s.getAge());
	}

}
