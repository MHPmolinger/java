package com.neusoft.mybatis.dao.one2one;

import java.util.List;

import com.neusoft.mybatis.one2one.domain.IdCard;

public interface IdCardMapper {

	public void save(IdCard idcard);
	
	public IdCard findById(int cid);
	
	public List<IdCard> findAll();
	
	public IdCard findOfPersonById(int cid);
	
}
