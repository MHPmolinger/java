package com.neusoft.mybatis.dao;

import com.neusoft.mybatis.domain.IdCard;

public interface IdCardMapper {

	public void save(IdCard idcard);
	
	public IdCard findById(int id);
}
