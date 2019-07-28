package com.neusoft.mybatis.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.neusoft.mybatis.domain.Student;

public interface StudentDao {

	@Insert(value="insert into tb_student(stuId,name,birthday,mobile) values(#{stuId},#{name},#{birthday},#{mobile})")
	public boolean save(Student stu);
	//@Selectע���ʾִ�е��ǲ�ѯ����
	@Select(value="select * from tb_student where stuId=#{stuid}")
	//ע��@Results������ʾ���صĽ��������
	@Results(value={
			 //column���ԣ���ʾ���ݿ���е��е����ƣ�property���ԣ���ʾʵ���������Ե����ƣ�javaType���ԣ���ʾʵ�����и����Ե����ͣ�jdbcType���ԣ���ʾ���е�����
			@Result(column="stuId",property="stuId",id=true,javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="name",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="birthday",property="birthday" ,javaType=Date.class,jdbcType=JdbcType.DATE),
			@Result(column="mobile",property="mobile",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public Student findById(String id);
	
	@Delete(value="delete from tb_student where stuId=#{stuId}")
	public void delete(String id);
	
	@Update(value="update tb_student set name=#{name},birthday=#{birthday},mobile=#{mobile} where stuId=#{stuId}")
	public void update(Student stu);
	
	@Select(value="select * from tb_student")
	@Results({
		@Result(column="stuId",property="stuId",id=true),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday"),
		@Result(column="mobile",property="mobile")
	})
	public List<Student> findAll();
}
