package com.neusoft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 事务满足的4个条件ACID
 * Atomicity：原子性：要么成功，要么撤回
 * Consistency：一致性：数据库状态与其他业务保持同步
 * Isolation：隔离性：事务独立运行，不会被其他事务所干扰
 * Durability：永久性：事务一旦提交不可回滚，对数据的改变是永久的
 * 
 * equals()与==的区别
 * equals()是object的方法，在object中比较两个对象引用是否指向同一对象
 * ==是比较运算符，比较两个数值是否相等；当比较引用类型时，比较两个引用是否指向同一对象
 */ 
public class LearnOther {
	public static void main(String[] args) {
		Map<String, String> data = new HashMap<>();
		data.put("no", "90");
		data.put("name", "sddss");
		data.put("job", "jobshi");
		Set<String> set = data.keySet();
		Iterator<String> it = set.iterator();
		Iterator<String> it1 = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next() + ":\t" + data.get(it1.next()));
		}
		Set<Map.Entry<String, String>> o = data.entrySet();
		for (Map.Entry<String, String> a : o)
			System.out.println(a);
		Set o9 = data.entrySet();
		for (Object a : o9)
			System.out.println(a);
	}
}
