package com.rbac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbac.entity.User;
import com.rbac.handler.Result;
import com.rbac.service.UserService;

//  http://localhost:8888/rbac/user/users

@RestController
@RequestMapping(value= {"/u"})
public class UserController {
	
	@Autowired
	private UserService userService ;
	
//	@RequestMapping(value= {} , method = {RequestMethod.GET})
	@GetMapping(value= {"/s"})
	public Result listUsers(){
		Result result = new Result();
		result.setCode(0);
		result.setData(userService.listUsers());
		return result ;
	}
	
	@PostMapping(value= {"/del/{user_id}"})
	public Result del(@PathVariable(name="user_id") Long user_id) {
		Result result = new Result();
		result.setCode(0);
		result.setData(userService.del(user_id));
		return result ;
	}
	
	@PostMapping(value= {"/update"})
	public Result update(User user) {
		Result result = new Result();
		result.setCode(0);
		result.setData(userService.update(user));
		return result ;
	}

	@PostMapping(value= {"/add"})
	public Result add(User user) {
		Result result = new Result();
		result.setCode(0);
		result.setData(userService.add(user));
		return result ;
	}
	
	@PostMapping(value= {"/user_role_add"})
	public Result user_role_add(@RequestParam(value="user_id") Long user_id , @RequestParam(name="ids[]") List<String> ids) {
		return new Result(userService.user_role_add(user_id , ids));
	}
	
	
}
