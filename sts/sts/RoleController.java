package com.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbac.handler.Result;
import com.rbac.service.RoleService;

@RestController
@RequestMapping(value= {"/r"})
public class RoleController {
	
	@Autowired
	private RoleService roleService ;
	
	@GetMapping(value= {"/roles/{current_page}/{page_size}"})
	public Result rolesPage (
			@PathVariable(name="current_page") int current_page , 
			@PathVariable(name="page_size") int page_size 
			){
		return  new Result(roleService.rolesPage(current_page , page_size));
	}
	
	@GetMapping(value= {"/s"})
	public Result roles (){
		return  new Result(roleService.roles());
	}

}
