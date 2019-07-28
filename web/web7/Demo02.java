package cn.zdxy.listener.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list=new LinkedList();
		list.add("aaa");
		list.add("bbb");
		Iterator it=list.iterator();
		while(it.hasNext()){
			String name=(String) it.next();
			list.add("ccc");
			it.remove();
		}

	}

}
