package com.neusoft.taobao.dao;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.taobao.domain.Product;
import com.neusoft.taobao.utils.DbUtils;

import java.sql.*;
public class ProductDao {

	public boolean save(Product p){
		boolean result=false;
		String sql="insert into tb_product(pno,pname,price,pdesc,imagePath)values(?,?,?,?,?)";
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, p.getPno());
				ps.setString(2, p.getPname());
				ps.setInt(3, p.getPrice());
				ps.setString(4, p.getPdesc());
				ps.setString(5, p.getImagePath());
				int n=ps.executeUpdate();
				if(n>0){
					result=true;
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Product> findAll(){
		List<Product> list=new ArrayList<Product>();
		String sql="select * from tb_product";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product p=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
					p=new Product();
					p.setPno(rs.getString("pno"));
					p.setPname(rs.getString("pname"));
					p.setPrice(rs.getInt("price"));
					p.setImagePath(rs.getString("imagePath"));
					p.setPdesc(rs.getString("pdesc"));
					list.add(p);
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
