package cn.neusoft.usermanager.dao;

import cn.neusoft.usermanager.domain.User;

import java.sql.*;
public class UserDao {

	public boolean save(User user){
		boolean result=false;
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into user(name,gender,birthday,loves,xueli,resume)values(?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "root");
			if(con!=null){
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getGender());
				ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
				ps.setString(4, user.getLoves());
				ps.setString(5, user.getXueli());
				ps.setString(6, user.getResume());
				int n=ps.executeUpdate();
				if(n>0){
					result=true;
					
				}
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
