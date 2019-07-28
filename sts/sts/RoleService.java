package com.rbac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rbac.entity.Role;
import com.rbac.mapper.RoleMapper;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper ;
	
	public PageInfo<Role> rolesPage(int current_page , int page_size ) {
		PageHelper.startPage(current_page, page_size);
		List<Role> roles = roleMapper.selectAll();
		PageInfo<Role> pageInfo = new PageInfo<Role>(roles);
		return pageInfo ;
	}
	
	public List<Role> roles() {
		return roleMapper.selectAll(); 
	}

	
}
