package cn.zdxy.dao;
import java.util.*;

import cn.zdxy.domain.User;
public class UserDao {

	private static List<User> users=new ArrayList<User>();
	static{
		users.add(new User("aaa","123456"));
		users.add(new User("lixiaoming","123456"));
		users.add(new User("lxm@yahoo.com.cn","123456"));
		users.add(new User("bbb","123456"));
	}
	
	public User findUser(String name,String password){
		for(User u:users){
			if(u.getUsername().equals(name)&& u.getPassword().equals(password)){
				return u;
			}
			
		}
		return null;
	}
	
	public String findBynamePassword(String name){
		for(User u:users){
			if(u.getUsername().equals(name)){
				return u.getPassword();
			}
		}
		return null;
	}
}
