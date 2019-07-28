package com.neusoft.atm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.atm.dao.AccountDao;
import com.neusoft.atm.dao.UserDao;
import com.neusoft.atm.domain.Account;
import com.neusoft.atm.utils.BeanFactory;
import com.neusoft.atm.utils.DbUtils;

public class AccountDaoImplByJdbc implements AccountDao {
     /*
      * create table tb_account
(
   id int primary key auto_increment ,
   cardNo varchar(19) not null unique,
   loginPwd varchar(15) not null,
   bankName varchar(25),
   cardType int default 0,
   balance numeric(8,2),
   bankStatus default 0,
   user_id varchar(50),
   constraint user_id_FK foreign key(user_id) references tb_user(id)
);
      * @see com.neusoft.atm.dao.AccountDao#save(com.neusoft.atm.domain.Account)
      */
	@Override
	public boolean save(Account account) throws SQLException {
		String sql="insert into tb_account(cardNo,loginPwd,bankName,cardType,balance,bankStatus,user_id) values(?,?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement ps=null;
		boolean result=false;
		con=DbUtils.getConnection();
		if(con!=null){
			ps=con.prepareStatement(sql);
			//要给问号位置赋值
			ps.setString(7, account.getUser().getId());
			ps.setString(1, account.getCardNo());
			ps.setString(2, account.getLoginPwd());
			ps.setString(3, account.getBankName());
			ps.setInt(4, account.getCardType());
			ps.setDouble(5, account.getBalance());
			ps.setInt(6, account.getBankStatus());
			
			int n=ps.executeUpdate();
			if(n>0){
				result=true;
			}
			DbUtils.close(con, ps);
		}
		return result;
	}

	@Override
	public void update(Account account) throws SQLException{
		//cardNo,loginPwd,bankName,cardType,balance,bankStatus,user_id
		String sql="update tb_account set loginPwd=?,bankName=?,cardType=?,balance=?,bankStatus=?,user_id=? where cardNo=?";
		Connection con=null;
		PreparedStatement ps= null;
		con=DbUtils.getTransactionConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				//要给对应的问号位置赋值
				ps.setString(1, account.getLoginPwd());
				ps.setString(2, account.getBankName());
				ps.setInt(3, account.getCardType());
				ps.setDouble(4, account.getBalance());
				ps.setInt(5,account.getBankStatus());
				ps.setString(6, account.getUser().getId());
				ps.setString(7, account.getCardNo());
				int n=ps.executeUpdate();
				if(n>0){
					System.out.println("修改账户信息成功！");
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new SQLException();
			}
		}

	}

	@Override
	public void deleteById(int id) {
		String sql="delete from tb_account where id=?";
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				int n=ps.executeUpdate();
				if(n>0){
					System.out.println("删除账户成功！");
				}else{
					System.out.println("删除账户失败！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con, ps);
			}
		}
	}

	@Override
	public void deleteByCardNo(String cardNo) {
		String sql="delete from tb_account where cardNo=?";
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, cardNo);
				int n=ps.executeUpdate();
				if(n>0){
					System.out.println("删除账户成功！");
				}else{
					System.out.println("删除账户失败！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con, ps);
			}
		}

	}

	@Override
	public boolean findByCardNoAndPwd(String cardNo, String pwd) {
		String sql="select count(*) from tb_account where cardNo=? and loginPwd=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean result=false;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				//要给对应的问号位置赋值
				ps.setString(1, cardNo);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				if(rs.next()){
					result=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con, ps, rs);
			}
		}
		return result;
	}

	@Override
	public Account findAccountByCardNoAndPwd(String cardNo, String pwd) {
		String sql="select * from tb_account where cardNo=? and loginPwd=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account account=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, cardNo);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				if(rs.next()){
					account=new Account();
					//把记录封装到实体对象中 
					account.setId(rs.getInt("id"));
					account.setCardNo(rs.getString("cardNo"));
					account.setLoginPwd(rs.getString("loginPwd"));
					account.setBalance(rs.getDouble("balance"));
					account.setBankName(rs.getString("bankName"));
					account.setBankStatus(rs.getInt("bankStatus"));
					account.setCardType(rs.getInt("cardType"));
					String user_id=rs.getString("user_id");
					UserDao userDao=BeanFactory.getBean(UserDao.class);
					account.setUser(userDao.findById(user_id));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con,ps,rs);
			}
		}
		return account;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByCardNo(String cardNo) {
		String sql="select * from tb_account where cardNo=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account account=null;
		con=DbUtils.getConnection();
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, cardNo);
			
				rs=ps.executeQuery();
				if(rs.next()){
					account=new Account();
					//把记录封装到实体对象中 
					account.setId(rs.getInt("id"));
					account.setCardNo(rs.getString("cardNo"));
					account.setLoginPwd(rs.getString("loginPwd"));
					account.setBalance(rs.getDouble("balance"));
					account.setBankName(rs.getString("bankName"));
					account.setBankStatus(rs.getInt("bankStatus"));
					account.setCardType(rs.getInt("cardType"));
					String user_id=rs.getString("user_id");
					UserDao userDao=BeanFactory.getBean(UserDao.class);
					account.setUser(userDao.findById(user_id));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.close(con,ps,rs);
			}
		}
		return account;
	}

	@Override
	public void updateBalance(String cardNo,double money) throws SQLException {
		String sql="update tb_account set balance=? where cardNo=?";
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getTransactionConnection();
		if(con!=null){
			
				ps=con.prepareStatement(sql);
				ps.setDouble(1, money);
				ps.setString(2, cardNo);
				int n=ps.executeUpdate();
			
			
		}
		ps.close();
	}

}
