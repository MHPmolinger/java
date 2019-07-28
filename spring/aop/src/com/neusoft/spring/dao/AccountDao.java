package com.neusoft.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.neusoft.spring.domain.Account;
@Repository
public class AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void tranfer(Account fromAccount,Account toAccount,int money){
		String sql="update account set balance=? where id=?";
		jdbcTemplate.update(sql,fromAccount.getBalance()-money,fromAccount.getId());
		int n=10/0;
		jdbcTemplate.update(sql,toAccount.getBalance()+money,toAccount.getId());
	}
	
	public Account findById(String id){
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		String sql="select * from account where id=?";
		return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
	}
}
