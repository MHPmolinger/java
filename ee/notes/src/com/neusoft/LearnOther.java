package com.neusoft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ���������4������ACID
 * Atomicity��ԭ���ԣ�Ҫô�ɹ���Ҫô����
 * Consistency��һ���ԣ����ݿ�״̬������ҵ�񱣳�ͬ��
 * Isolation�������ԣ�����������У����ᱻ��������������
 * Durability�������ԣ�����һ���ύ���ɻع��������ݵĸı������õ�
 * 
 * equals()��==������
 * equals()��object�ķ�������object�бȽ��������������Ƿ�ָ��ͬһ����
 * ==�ǱȽ���������Ƚ�������ֵ�Ƿ���ȣ����Ƚ���������ʱ���Ƚ����������Ƿ�ָ��ͬһ����
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
