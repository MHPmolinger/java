package com.neusoft.atm.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.atm.domain.Account;

public interface AccountDao {
    //向账号表中插入一条记录 
	public boolean save(Account account)throws SQLException;
	 //更新一个账户
	public void update(Account account)throws SQLException;
	//通过id来删除一个账户信息
	public void deleteById(int id);
	//通过账号来删除一个账户信息
	public void deleteByCardNo(String cardNo);
	//判断登录是否成功
	public boolean findByCardNoAndPwd(String cardNo,String pwd);
	//通过账号和密码来查询一个账户信息
	public Account findAccountByCardNoAndPwd(String cardNo,String pwd);
	//查询所有的账户信息
	public List<Account> findAll();
	//通过卡号来查询一个账户的信息
	public Account findByCardNo(String cardNo);
	  //更新余额
	public void updateBalance(String cardNo,double money )throws SQLException;
}
