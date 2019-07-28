package com.neusoft.atm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.neusoft.atm.dao.ResultSetHandler;

public class DbUtils {

	private static String driverClass;
	private static String dburl;
	private static String username;
	private static String password;
	//TreadLocal表示和当前线程绑定的这样一个对象，该对象中可以用来保存（绑定）一个数据库连接
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	static{
		 //Class
		InputStream in=DbUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		//InputStream in=DbUtils.class.getResourceAsSttream("dbconfig.properties");
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
		    try {
				Class.forName(driverClass);
				con=DriverManager.getConnection(dburl, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
	}
	
	public static Connection getTransactionConnection(){
		Connection con=null;
		//先从当前线程绑定对象中获取，如果没有在创建 
		con=tl.get();
		if(con==null){
			con=getConnection();
			//并且把该连接设置到当前线程绑定的对象中来
			tl.set(con);
		}
		return con;
	}
	public static void closeTransactionConnection(){
		//先从当前线程绑定对象中获取
		Connection con=tl.get();
		if(con!=null){
			tl.remove();//把当前线程绑定对象中的连接给移除调
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con,Statement st){
		 if(st!=null){
			 try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(con!=null){
				 try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
	}
	 
	public static void close(Connection con,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			close(con,st);
		}
	}
	//开启事务
	public static void startTransaction() throws SQLException{
		Connection con=getTransactionConnection();
		      //把事务设置为手动提交（默认是自动提交的） 
				con.setAutoCommit(false);
			
		
	}
	public static void  commitTransaction() throws SQLException{
		Connection con=tl.get();
		if(con!=null){
			con.commit();
		}
	}
	
	public static void rollbackTransaction() throws SQLException{
		Connection con=tl.get();
		if(con!=null){
			con.rollback();
		}
	}
	/**
	 * 
	 * @param con:因为更新操作有可能存在事务问题，所有我们采用传递连接对象的方式
	 * @param sql:要执行的sql语句
	 * @param args:表示sql语句中的参数
	 * @return
	 */
	public static boolean update(Connection con,String sql,Object[] args){
		boolean result=false;
		PreparedStatement ps=null;
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				//要给问号位置赋值
				for(int i=0;args!=null&&i<args.length;i++){
					//需要对一些特殊的类型进行转换，如boolean,Date类型等
					if(args[i] instanceof java.lang.Boolean ||args[i].getClass()==boolean.class){
						//进行布尔类型的转换，boolean->int   ,true->1,false->0
						boolean b=(boolean)args[i];
						ps.setInt(i+1,b?1:0 );
					}else if(args[i].getClass()==java.util.Date.class){
						//要进行java.util.Date->java.sql.Date转换
						java.util.Date date=(java.util.Date)args[i];
						ps.setDate(i+1, new java.sql.Date(date.getTime()));
					}else{
						ps.setObject(i+1, args[i]);
					}
					
				}
				int n=ps.executeUpdate();
				if(n>0){
					result=true;
					//DbUtils.commitTransaction();
				}
				ps.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				try {
//					DbUtils.rollbackTransaction();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		}
		return result;
	}
	
	public static Object query(String sql,Object[] args,ResultSetHandler handler){
		Object t=null;
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   con=DbUtils.getConnection();
		   if(con!=null){
			   try {
				ps=con.prepareStatement(sql);
				//要给问号位置赋值
				for(int i=0;args!=null&&i<args.length;i++){
					//要考虑类型转换的问题
					if(args[i].getClass()==java.util.Date.class){
						//进行日期类型的转换
						java.util.Date date=(java.util.Date)args[i];
						ps.setDate(i+1, new java.sql.Date(date.getTime()));
					}else if(args[i].getClass()==java.lang.Boolean.class||args[i].getClass()==boolean.class){
						boolean b=(boolean)args[i];
						ps.setInt(i+1, b?1:0);
					}else{
						ps.setObject(i+1, args[i]);
					}
					
				}
				//执行查询
				rs=ps.executeQuery();
				//调用ResultSetHandler中的handle方法
				t=handler.handler(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con,ps,rs);
			}
			   
		   }
		return t;
	}
}
