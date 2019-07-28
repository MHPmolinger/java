package com.neusoft.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public static SqlSession getSqlSession() throws IOException{
		return getSqlSessionFactory().openSession();
	}
}
