package com.neusoft;

/**
 * 1����дһ��Java����(����һ���������࣬һ���߳��ࡣ�����������д���2���̣߳�������һ���̵߳����ȼ���Ϊ10,
 * ��һ���̵߳����ȼ���Ϊ6�������ȼ�Ϊ10���̴߳�ӡ200�Ρ��߳�1�������С���
 *  ���ȼ�Ϊ6���̴߳�ӡ200�Ρ��߳�2�������С��� [ѡ����]
 * 2����дһ�����ӱ�ÿ��һ���ӣ��ڿ���̨��ӡ������ʱ�䣨������ ʱ���룩 �� [������] ��ʹ��Thread.sleep(����)��
 * �������߳���Ϣ�ķ�ʽʵ�� ����ѧϰ �� SimpleDateFormate �Լ�Date �� �ȹ������ʹ�ã��μ�API�ĵ��� 
 * 3����һ����� ���ʵ��
 * �ڿ���̨ ��ӡ 1��2��3������59 1Min 1 1Min2 1Min3 1Min4���� 
 * 4�����ø߼��ַ��� ʵ�ֽ��˷��ھ��� д��
 * ĳ����txt�ļ���д��� �ٽ���������� д�뵽��һ��txt�ļ��� 
 * 5������ʦ֮ǰ���ı��Ծ�����������Լ������� ����ϰ���� �ٶȣ�������
 */

public class TestTT{
public static void main(String[] args) {
	Thread1 obj1=new Thread1();//200�δ�ӡ
	Thread t1=new Thread(obj1);
	Thread t2=new Thread(obj1);
//	t1.setPriority(10);
//	t2.setPriority(6);
	t1.start();
	t2.start();
//	try {
//		t2.join();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
}
