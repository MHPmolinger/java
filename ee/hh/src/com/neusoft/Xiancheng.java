package com.neusoft;

public class Xiancheng extends Thread {
	int ticket = 50;

	@Override
	public void run() {
		while(ticket>0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			salesTicket();
		}
		} 
		
	
	public synchronized void salesTicket(){
		if(ticket>0){
			ticket--;
			System.out.println("�ɹ�����һ��Ʊ��ʣ��"+ticket+"��Ʊ��");
		}else{
			System.out.println("Ʊ��������");
		}
	}

	public static void main(String[] args) {
		Xiancheng obj = new Xiancheng();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);

		t1.start();
		t2.start();
		t3.start();

	}
}
