package cn.neusoft_ajax;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {

	private DbUtils(){}
	
	private static String driverClass;
	private static String dburl;
	private static String username;
	private static String password;
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	static{
		InputStream in=DbUtils.class.getClassLoader().getResourceAsStream("db-config.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			driverClass=prop.getProperty("driverClass");
			dburl=prop.getProperty("dburl");
			username=prop.getProperty("user");
			password=prop.getProperty("password");
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
	
	public static Connection getConnection(){
		Connection con=null;
		con=tl.get();
		
		if(con==null){
			try {
				Class.forName(driverClass);
				con=DriverManager.getConnection(dburl,username,password);
				tl.set(con);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return con;
	}
	
	public static void close(){
		Connection con=tl.get();
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tl.remove();
		}
	}
	public static void close(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(st);
	}
}
