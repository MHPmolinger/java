package com.rbac.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_user")
public class User implements Serializable{

	private static final long serialVersionUID = 3239915659579242952L;
	@Id
	private Long user_id ;
	private String user_name ;
	private String user_pwd ;
	private String user_status ;
	private Timestamp user_ctime ;
	

}
