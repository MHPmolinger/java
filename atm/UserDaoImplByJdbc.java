package com.neusoft.atm.dao.impl;

import com.neusoft.atm.dao.UserDao;
import com.neusoft.atm.domain.User;
import com.neusoft.atm.utils.DbUtils;

import java.sql.*;
import java.util.List;
public class UserDaoImplByJdbc implements UserDao {

	@Override
	public User findById(String id) {
	   String sql="select * from tb_user where id=?";
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   User user=null;
	   //获取连接
	   con=DbUtils.getConnection();
	   if(con!=null){
		   try {
			ps=con.prepareStatement(sql);
			//要给问号位置赋值 
			ps.setString(1, id);
			//要真正执行查询，并返回结果集对象
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				//把记录中的对应列的值设置到用户对象user对应的属性上来
				user.setId(rs.getString(1));
				user.setName(rs.getString("name"));
				user.setSex(rs.getInt(3)==1?true:false);
				user.setIdcard(rs.getString("idcard"));
				user.setMobile(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(con, ps, rs);
		}
	   }
		return user;
	}

	@Override
	public User findByIdCard(String idcard) {
		  String sql="select * from tb_user where idcard=?";
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   User user=null;
		   //获取连接
		   con=DbUtils.getConnection();
		   if(con!=null){
			   try {
				ps=con.prepareStatement(sql);
				//要给问号位置赋值 
				ps.setString(1, idcard);
				//要真正执行查询，并返回结果集对象
				rs=ps.executeQuery();
				if(rs.next()){
					user=new User();
					//把记录中的对应列的值设置到用户对象user对应的属性上来
					//String id=rs.getString(1);
					//user.setId(id);
					user.setId(rs.getString(1));
					user.setName(rs.getString("name"));
					user.setSex(rs.getInt("sex")==1?true:false);
					user.setIdcard(rs.getString("idcard"));
					user.setMobile(rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con, ps, rs);
			}
		   }
			return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
