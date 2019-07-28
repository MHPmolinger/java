package com.rbac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbac.entity.User;
import com.rbac.entity.User_Role;
import com.rbac.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper ;
	
	public List<User> listUsers(){
		return userMapper.listUsers() ;
	}

	public Boolean del(Long user_id) {
		return userMapper.del(user_id);
	}

	public Boolean update(User user) {
		return userMapper.update(user);
	}

	public Object add(User user) {
		return userMapper.add(user);
	}

	public Boolean user_role_add(Long user_id, List<String> ids) {
		List<User_Role> list = new ArrayList<User_Role>();
		User_Role user_role = null ;
		for (int i = 0; i < ids.size(); i++) {
			user_role = new User_Role() ;
			user_role.setUser_id(user_id);
			user_role.setRole_id(Long.parseLong(ids.get(i)));
			list.add(user_role);
		}
		return userMapper.user_role_add(list);
	}
}
