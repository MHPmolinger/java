package cn.neusoft_ajax;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class GoodsTypeDao {

	public List<GoodsType> findAll(){
		List<GoodsType> list=new ArrayList<GoodsType>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
					                            "scott", "tiger");
			 String sql="select * from tb_GoodsClassity";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery(); 
			 GoodsType gt=null;
			 while(rs.next()){
				 gt=new GoodsType();
				 gt.setId(rs.getString(1));
				 gt.setName(rs.getString(2));
				 gt.setGtype(rs.getString(3));
				 list.add(gt);
			 }
			 System.out.println(list.size());
			 rs.close();
			 ps.close();
			 con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
