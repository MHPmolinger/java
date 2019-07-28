package com.rbac.handler;

import lombok.Getter;
import lombok.Setter;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor

@Setter
@Getter
public class Result {

	private Integer code = 200 ;
	private String msg = "正常";
	private Integer count = 0 ;
	private Object data ;
	
	public Result() {
	}
	
	public Result(Object data) {
		super();
		this.data = data;
	}
	
}
