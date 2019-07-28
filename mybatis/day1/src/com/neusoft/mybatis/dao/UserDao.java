package com.neusoft.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.mybatis.domain.User;

public interface UserDao {

	public void save(User user);
	
	public User findById(String userId);
	
	public List<User> findAll();
	
	public void deleteById(String userId);
	
	public void updateUser(User user);
	
	public User findByNameAndId(@Param("userName")String name,@Param("id")String userId);
	
	public User findByMap(Map<String,Object> map);
	
	public User findByListId(List<String> ids);
}
