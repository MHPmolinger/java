package com.neusoft.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.neusoft.mybatis.dao.RoleMapper;
import com.neusoft.mybatis.dao.StudentDao;
import com.neusoft.mybatis.dao.User2Mapper;
import com.neusoft.mybatis.dao.UserDao;
import com.neusoft.mybatis.domain.Role;
import com.neusoft.mybatis.domain.Student;
import com.neusoft.mybatis.domain.User;
import com.neusoft.mybatis.domain.User2;
import com.neusoft.mybatis.utils.SqlSessionFactoryUtils;

public class MyBatisTest {

	@Test
	public void test1() {
		try {
			InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
			SqlSession sqlSession=sqlSessionFactory.openSession();
			System.out.println(sqlSession);
			UserDao userDao=sqlSession.getMapper(UserDao.class);
			System.out.println(userDao);
			User user=new User();
			user.setUserId("10002");
			user.setName("王五");
			user.setAge(20);
			user.setBirthday(new Date());
			userDao.save(user);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession=null;
		
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao userDao=sqlSession.getMapper(UserDao.class);
			User user=userDao.findById("10002");
			System.out.println(user);
		}catch(Exception e){
			sqlSession.rollback();
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
			UserDao userDao=sqlSession.getMapper(UserDao.class);
			List<User> users=userDao.findAll();
			for(User user:users){
				System.out.println(user);
			}
			
		}catch(Exception e){
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testDelete(){
            SqlSession sqlSession=null;
		
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao userDao=sqlSession.getMapper(UserDao.class);
			 userDao.deleteById("10001");
			 sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testUpdate(){
            SqlSession sqlSession=null;
		
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao userDao=sqlSession.getMapper(UserDao.class);
			  User user=userDao.findById("10002");
			  System.out.println("修改前："+user);
			  user.setAge(30);
			  user.setName("赵六");
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  user.setBirthday(sdf.parse("1990-12-23"));
			  userDao.updateUser(user);
			  System.out.println(user);
              sqlSession.commit();	
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test6(){
		List list=new ArrayList();
		list.add("sadf");
		list.add("222");
		List<Integer> li=list;
	}
	
	@Test
	public void testStudentInsert(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			StudentDao sdao=sqlSession.getMapper(StudentDao.class);
			Student stu=new Student();
			stu.setStuId("10003");
			stu.setName("wangwu");
			stu.setBirthday(new Date());
			stu.setMobile("12345678901");
			boolean result=sdao.save(stu);
			sqlSession.commit();
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testStudentSelect(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			StudentDao sdao=sqlSession.getMapper(StudentDao.class);
			Student stu=sdao.findById("10001");
			System.out.println(stu);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	@Test
	public void testStudentUpdate(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			StudentDao sdao=sqlSession.getMapper(StudentDao.class);
			Student stu=sdao.findById("10001");
			stu.setName("李四");
			stu.setMobile("99999999999");
			sdao.update(stu);
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
	public void testStudentDelete(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			StudentDao sdao=sqlSession.getMapper(StudentDao.class);
			sdao.delete("10001");
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
	public void testStudentFindAll(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			StudentDao sdao=sqlSession.getMapper(StudentDao.class);
			List<Student> list=sdao.findAll();
			for(Student stu:list){
				System.out.println(stu);
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
	public void test7(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			   RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			   Role role=new Role();
			   role.setName("普通用户");
			   role.setDesc("具有分配员工账户和密码的功能");
			   roleMapper.save(role);
			   sqlSession.commit();
			   System.out.println(role.getId());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test8(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			  User2 user=new User2();
			  User2Mapper um=sqlSession.getMapper(User2Mapper.class);
			  user.setUserName("zhangsan");
			  um.save(user);
			  sqlSession.commit();
			  System.out.println(user.getUserId());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test9(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao udao=sqlSession.getMapper(UserDao.class);
			User user=udao.findByNameAndId("赵六", "10002");
			System.out.println(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test10(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao udao=sqlSession.getMapper(UserDao.class);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("uid", "10002");
			User user=udao.findByMap(map);
			System.out.println(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test11(){
		SqlSession sqlSession=null;
		try{
			sqlSession=SqlSessionFactoryUtils.getSqlSession();
			UserDao udao=sqlSession.getMapper(UserDao.class);
			 List<String> ids=new ArrayList<String>();
			 ids.add("10002");
			 ids.add("10003");
			User user=udao.findByListId(ids);
			System.out.println(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
