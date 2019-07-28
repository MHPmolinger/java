package com.neusoft.atm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.neusoft.atm.dao.AccountDao;
import com.neusoft.atm.domain.Account;
import com.neusoft.atm.utils.DbUtils;

public class AccountDaoImplByMyBatis implements AccountDao {

	@Override
	public boolean save(Account account) {
		String sql="insert into tb_account(cardNo,loginPwd,bankName,cardType,balance,bankStatus,user_id) values(?,?,?,?,?,?,?)";
		Connection con=DbUtils.getTransactionConnection();
		return DbUtils.update(con, sql, new Object[]{account.getCardNo(),account.getLoginPwd(),account.getBankName(),account.getCardType(),account.getBalance(),account.getBankStatus(),account.getUser().getId()});

	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByCardNo(String cardNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean findByCardNoAndPwd(String cardNo, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findAccountByCardNoAndPwd(String cardNo, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		String sql="select * from tb_account";
		
		return (List<Account>) DbUtils.query(sql, null, new BeanListResultSetHandler(Account.class));
	}

	@Override
	public Account findByCardNo(String cardNo) {
		String sql="select * from tb_account where cardNo=?";
		return (Account) DbUtils.query(sql, new Object[]{cardNo}, new BeanResultSetHandler(Account.class));
	}

	@Override
	public void updateBalance(String cardNo,double money) {
		String sql="update tb_account set balance=? where cardNo=?";
		Connection con=null;
	
		con=DbUtils.getTransactionConnection();
		DbUtils.update( con, sql, new Object[]{money,cardNo});

	}

}
