package com.neusoft.atm.dao.impl;

import java.util.List;

import com.neusoft.atm.dao.UserDao;
import com.neusoft.atm.domain.User;
import com.neusoft.atm.utils.DbUtils;

public class UserDaoImplByHibernate implements UserDao {

	@Override
	public User findById(String id) {
		String sql="select * from tb_user where id=?";
		return (User) DbUtils.query(sql, new Object[]{id}, new BeanResultSetHandler(User.class));
	}

	@Override
	public User findByIdCard(String idcard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll() {
		String sql="select * from tb_user ";
		return (List<User>) DbUtils.query(sql, null, new BeanListResultSetHandler(User.class));
	}

}
