package com.neusoft.atm.service;

import java.sql.SQLException;

import com.neusoft.atm.dao.AccountDao;
import com.neusoft.atm.dao.UserDao;
import com.neusoft.atm.dao.impl.AccountDaoImplByJdbc;
import com.neusoft.atm.domain.Account;
import com.neusoft.atm.domain.User;
import com.neusoft.atm.exception.OpenNewAccountException;
import com.neusoft.atm.utils.BeanFactory;
import com.neusoft.atm.utils.DbUtils;
/*
 * Spring: DI(IoC)
 */
public class AccountService {
     
	private AccountDao accountDao=BeanFactory.getBean(AccountDao.class);

	private UserDao userDao=BeanFactory.getBean(UserDao.class);
	/**
	 * 功能：存款
	 * 作者：
	 * 时间：
	 * 版本：
	 * @param cardNo
	 * @param money
	 */
	public boolean deposit(String cardNo,Double money){
		boolean result=false;
		return result;
	}
	
	/**
	 *功能：取款
	 * @param cardNo
	 * @param money
	 * @return
	 */
	public boolean withdraw(String cardNo,double money){
        boolean result=false;
		try {
			DbUtils.startTransaction();
			//获取余额
			Account account=accountDao.findByCardNo(cardNo);
			if(account.getBalance()-money>=0){
				money=account.getBalance()-money;
				accountDao.updateBalance(cardNo, money);
				//int n=10/0;
				DbUtils.commitTransaction();
				System.out.println("取款成功！");
				result=true;
			}else{
				System.out.println("对不起，你的余额不足！");
				result=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				DbUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 功能： 转账 
	 * @param fromCardNo
	 * @param toCardNo
	 * @param money
	 * @return   0:代表余额不足，1，代表转账失败，2.代表转账成功！
	 */
	public int transfer(String  fromCardNo,String toCardNo,double money){
		int result=-1;
		//1.检查被转账户余额是否够
		  Account fromAccount= accountDao.findByCardNo(fromCardNo);
		  if(fromAccount.getBalance()-money<=0){
			  result=0;//0代表余额不足
			  return result;
		  }
		  //开启事务
		  try {
			DbUtils.startTransaction();
			//2.当余额够转的情况下，给fromCardNo-money
			accountDao.updateBalance(fromCardNo, fromAccount.getBalance()-money);
			//3.从toCardNo+money
			Account toAccount=accountDao.findByCardNo(toCardNo);
			int m=10/0;
			accountDao.updateBalance(toCardNo, toAccount.getBalance()+money);
			//提交事务
			DbUtils.commitTransaction();
			result=2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result= 1;
			try {
				DbUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return result;
	}
	/**
	 * 功能： 修改密码
	 * @param cardNo
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public boolean modifier(String cardNo,String oldPwd,String newPwd){
		boolean result=false;
		
		return result;
	}
	/**
	 * 功能：登录
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public boolean login(String cardNo,String password){
		boolean result=false;
		
		return result;
	}
	/**
	 * 功能： 查询一个账户
	 * @param cardNo
	 * @return
	 */
	public Account checkAccount(String cardNo){
		Account account=null;
		
		return account;
	}
	/**
	 * 功能：新开账户
	 * @param account
	 * @return
	 */
	public String  openNewAccount(Account account){
		String info="";
		//查询该账户对应的用户是否合法
		User user=account.getUser();
		//获取用户的ID或身份证号（居多）
		String idcard=user.getIdcard();
		//查询用户
		User user2=userDao.findByIdCard(idcard);
		if(user2==null){
			info="对不起该用户不合法，办卡失败！";
		}else if(!user2.getName().equalsIgnoreCase(user.getName())){
			info="系统中用户的姓名和提供的姓名不一致，请核对！";
		}else  {
			  boolean result;
			try {
				DbUtils.startTransaction();
				result = accountDao.save(account);
				 if(result){
					  info="开户成功！,您的卡号为：["+account.getCardNo()+"],初始密码为：["+account.getLoginPwd()+"]"; 
				  }else{
					  info="开户失败！";
				  }
				 DbUtils.commitTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					DbUtils.rollbackTransaction();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				throw new OpenNewAccountException("开户失败！");
			}
			 
			
		}
		return info;
	}
}
