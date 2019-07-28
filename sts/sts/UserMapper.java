package com.rbac.mapper;

import java.util.List;

import com.rbac.entity.User;
import com.rbac.entity.User_Role;

public interface UserMapper {

	public List<User> listUsers();

	public Boolean del(Long user_id);

	public Boolean update(User user);

	public Boolean add(User user);

	public Boolean user_role_add(List<User_Role> list);
	
}
