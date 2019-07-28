package com.rbac.entity;

import java.sql.Timestamp;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_role")
public class Role {

	private Long role_id ;
	private String role_name ;
	private String role_desc ;
	private String role_status ;
	private Timestamp role_ctime ;
}
