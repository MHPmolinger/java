package com.neusoft.mybatis.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.neusoft.mybatis.dao.ProductMapper;
import com.neusoft.mybatis.domain.Product;
import com.neusoft.mybatis.utils.SqlSessionFactoryUtils;

public class MyBatisTest {

	@Test
	public void test1(){
		   SqlSession sqlSession=null;
		   try{
			   sqlSession=SqlSessionFactoryUtils.getSqlSession();
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(sqlSession!=null){
				   sqlSession.close();
			   }
		   }
	}
	@Test
	public void test2(){
		 SqlSession sqlSession=null;
		   try{
			   sqlSession=SqlSessionFactoryUtils.getSqlSession();
			   ProductMapper mapper=sqlSession.getMapper(ProductMapper.class);
			   Map<String,Object> map=mapper.findIdAndNameById(1);
			   for(String key:map.keySet()){
				   System.out.print(key+":="+map.get(key)+" , ");
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(sqlSession!=null){
				   sqlSession.close();
			   }
		   }
	}
	
	@Test
	public void test3(){
		   SqlSession sqlSession=null;
		   try{
			   sqlSession=SqlSessionFactoryUtils.getSqlSession();
			   ProductMapper mapper=sqlSession.getMapper(ProductMapper.class);
			   List<Map<String,Object>> list=mapper.findAllReturnList();
			   for(Map<String,Object> map:list){
				   for(String key:map.keySet()){
					   System.out.print(key+":="+map.get(key)+" ");
				   }
				   System.out.println();
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(sqlSession!=null){
				   sqlSession.close();
			   }
		   }
	}
	
	@Test
	public void test4(){
		   SqlSession sqlSession=null;
		   try{
			   sqlSession=SqlSessionFactoryUtils.getSqlSession();
			   ProductMapper mapper=sqlSession.getMapper(ProductMapper.class);
			   Map<Integer,Product> map=mapper.findByIdReturnMap(2);
			   for(Integer id:map.keySet()){
				   System.out.print(id+"::"+map.get(id));
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(sqlSession!=null){
				   sqlSession.close();
			   }
		   }
	}
}
