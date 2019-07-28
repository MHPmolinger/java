package cn.neusoft_ajax;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class xStreamTest {

	@Test
	public void test1Stream(){
		
		User user=new User();
		user.setId("1001");
		user.setName("张三");
		user.setAge(20);
		XStream xstream=new XStream();
		xstream.alias("user", User.class);
		String xml=xstream.toXML(user);
		System.out.print(xml);
	}
	
	@Test
	public void test2(){
		List<User> list=new ArrayList<User>();
		User user=new User();
		user.setId("1001");
		user.setName("张三");
		user.setAge(20);
		list.add(user);
		
		User user2=new User();
		user2.setId("1002");
		user2.setName("李四");
		user2.setAge(23);
		list.add(user2);
		XStream xstream=new XStream();
		xstream.alias("users", List.class);
		xstream.alias("user", User.class);
		String xml=xstream.toXML(list);
		System.out.print(xml);
	}
	
	@Test
	public void test4(){
		GoodsTypeDao dao=new GoodsTypeDao();
		List<GoodsType> list=dao.findAll();
		XStream xstream=new XStream();
		xstream.alias("goodsTypes", List.class);
		xstream.alias("goodsType", GoodsType.class);
		String xml=xstream.toXML(list);
		System.out.print(xml);
	}
	
	
}
