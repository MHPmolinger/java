package cn.zdxy.listener.demo;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**面试题目：事件监听机制的原理：
 * 1.时间监听器机制涉及到三个组件：分别是事件源、监听器（也称为
 * 事件处理器）和事件对象。
 * 2.但事件源上发生某个操作时（如关闭窗口操作），事件监听器的某个
 * 方法（例如windowsColsing)立即就会被事件源对象调用,事件源在调用
 * 事件监听器的某个方法时会把事件对象传递给该方法，开发人员可通过该事件
 * 对象就可以得到事件源，从而对事件源进行处理。
 * 
 * @author Administrator
 *
 */
public class ListenerDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1.创建一个事件源，这里是一个window对话框
		Frame f=new Frame();
		//设置窗口的大小
		f.setSize(400, 500);
		//设置窗口可见
		f.setVisible(true);
		//2.注册事件监听器
		f.addWindowListener(new MyWindowListener());
//		f.addWindowListener(new WindowListener(){
//
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void windowClosing(WindowEvent e) {
//				// 通过事件对象获取是那个一事件源
//				Frame f=(Frame) e.getSource();
//				f.dispose();//关闭窗口
//				
//			}
//
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});

	}
  
}
class MyWindowListener implements WindowListener{

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		// 3.有事件源来调用时间监听器上的某个方法，
				Frame f=(Frame)e.getSource();
				f.dispose();
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}