package com.neusoft.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.neusoft.mybatis.dao.one2one.IdCardMapper;
import com.neusoft.mybatis.dao.one2one.PersonMapper;
import com.neusoft.mybatis.one2one.domain.IdCard;
import com.neusoft.mybatis.one2one.domain.Person;
import com.neusoft.mybatis.utils.SqlSessionFactoryUtils;

public class One2OneTest {

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
	public void testAdd(){
		 SqlSession sqlSession=null;
		   try{
			   sqlSession=SqlSessionFactoryUtils.getSqlSession();
			   IdCardMapper mapper=sqlSession.getMapper(IdCardMapper.class);
			   IdCard idcard=new IdCard();
			   idcard.setCardNo("77777777");
			   mapper.save(idcard);
			   sqlSession.commit();
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
			   Person p=new Person();
			   p.setGender(true);
			   p.setName("ÀîËÄ");
			   IdCardMapper imapper=sqlSession.getMapper(IdCardMapper.class);
			   IdCard idcard=imapper.findById(3);
			   p.setIdcard(idcard);
			   PersonMapper pmapper=sqlSession.getMapper(PersonMapper.class);
			   pmapper.save(p);
			   sqlSession.commit();
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
			   IdCardMapper imapper=sqlSession.getMapper(IdCardMapper.class);
			   IdCard idcard=imapper.findOfPersonById(1);
			   System.out.println(idcard);
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
			   PersonMapper pmapper=sqlSession.getMapper(PersonMapper.class);
			   Person p=pmapper.findById(3);
			   System.out.println(p);
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(sqlSession!=null){
				   sqlSession.close();
			   }
		   }
	}
}
