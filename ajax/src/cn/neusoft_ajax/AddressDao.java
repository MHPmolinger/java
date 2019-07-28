package cn.neusoft_ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {

	public Province findProvinceById(String id){
		Province p=null;
		String sql="select * from tb_province where id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				if(rs.next()){
					p=new Province();
					p.setId(rs.getString(1));
					p.setName(rs.getString(2));
				}
			  DbUtils.close(ps, rs);
			  DbUtils.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	public List<Province> findAllProvinces(){
		List<Province> list=new ArrayList<Province>();
		String sql="select * from tb_province ";
		Connection con=null;
		Province p=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				
				rs=ps.executeQuery();
				while(rs.next()){
					p=new Province();
					p.setId(rs.getString(1));
					p.setName(rs.getString(2));
					list.add(p);
				}
			  DbUtils.close(ps, rs);
			  DbUtils.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public City findCityById(String id){
		City c=null;
		String sql="select * from tb_city where id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				if(rs.next()){
					c=new City();
					c.setId(rs.getString(1));
					c.setName(rs.getString(2));
					String pid=rs.getString(3);
					c.setProvince(findProvinceById(pid));
				}
			  DbUtils.close(ps, rs);
			  DbUtils.close();
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public List<City> findCitysByProviceId(String pid){
		List<City> list=new ArrayList<City>();
		String sql="select * from tb_city where province_id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		City c=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, pid);
				rs=ps.executeQuery();
				while(rs.next()){
					c=new City();
					c.setId(rs.getString(1));
					c.setName(rs.getString(2));
					c.setProvince(new Province(rs.getString(3)));
					list.add(c);
				}
				DbUtils.close(ps, rs);
				DbUtils.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
