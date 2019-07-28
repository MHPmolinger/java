package com.neusoft.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.neusoft.mybatis.domain.Product;

public interface ProductMapper {

	public Map<String ,Object> findIdAndNameById(int pid);
	
	@MapKey(value="pid")
	public Map<Integer ,Product> findByIdReturnMap(int pid);
	
	public List<Map<String,Object>> findAllReturnList();
}
