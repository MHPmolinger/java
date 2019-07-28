package cn.neusoft_ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import flexjson.JSONSerializer;

public class FlaxJSONTest {

	@Test
	public void testFlaxJson1(){
	   List<User> users=new ArrayList<User>();
	   User user1=new User();
	   user1.setId("1001");
	   user1.setName("zhangsan");
	   user1.setAge(20);
	   users.add(user1);
	   
	   User user2=new User();
	   user2.setId("1002");
	   user2.setName("王五");
	   user2.setAge(25);
	   users.add(user2);
	   JSONSerializer jsonSerializer=new JSONSerializer();
	  // String jsonusers=jsonSerializer.serialize(users);
	   String jsonusers=jsonSerializer.exclude("class").serialize(users);
	   System.out.print(jsonusers);
	}
	@Test
	public void test2(){
		Department dept=new Department();
		dept.setId("10001");
		dept.setName("java开发部");
		dept.setCreateTime(new Date());
		Employee emp1=new Employee();
		emp1.setId("1001");
		emp1.setName("张三");
		emp1.setSalary(4500);
		emp1.setDept(dept);
		dept.getEmps().add(emp1);
		
		Employee emp2=new Employee();
		emp2.setId("1002");
		emp2.setName("李四");
		emp2.setSalary(5500);
		emp2.setDept(dept);
		dept.getEmps().add(emp2);
		JSONSerializer jsonserializer=new JSONSerializer();
		String context=jsonserializer.exclude("*.class").include("emps").serialize(dept);
		System.out.print(context);
		
	}
	
	@Test
	  public void test3(){
		Department dept=new Department();
		dept.setId("10001");
		dept.setName("java开发部");
		dept.setCreateTime(new Date());
		Employee emp1=new Employee();
		emp1.setId("1001");
		emp1.setName("张三");
		emp1.setSalary(4500);
		emp1.setDept(dept);
		dept.getEmps().add(emp1);
		JSONSerializer jsonserializer=new JSONSerializer();
		String content=jsonserializer.exclude("*.class").serialize(emp1);
		System.out.print(content);
	}
}
