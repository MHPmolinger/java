package com.rbac.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_Role {

	private Long user_role_id ;
	private Long user_id ;
	private Long role_id ;
	private Timestamp user_role_ctime ;
}
