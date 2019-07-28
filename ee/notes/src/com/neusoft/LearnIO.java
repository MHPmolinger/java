package com.neusoft;

public class LearnIO {
/**
 * 1、Java语言对于 计算机磁盘中文件的操作   使用 IO流技术操作
 *   I代表 input 输入     指的是  磁盘内容读入 内存
 *   O代表 output 输出  指的是  内存数据流出 到磁盘
 * 2、首先明确一个概念：文件操作 也好  网络传递数据 也好 底层都是将这些数据转化成  字节流 进行操作过程‘
 * 3、Java对于文件的一个 操作 工具类 InputStream
 * 4、File类
 
	
	public static void main(String[] args) {
//		File file=new File("e://dream.txt");
//		System.out.println(file.exists());
//		File  file=new File("e://3//4");
//		file.mkdirs();
		try {
			FileInputStream  fis=new FileInputStream(new File("e://dream.txt"));
			byte[] b=new byte[50];
			while(fis.read(b)>-1){
				System.out.println(new String(b));
				b=new byte[50];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 	File file=new File("e://a");
		String[] filename=file.list();
		String str;
		File newf;
		File oldf;
		for(int i=0;i<filename.length;i++){
			//System.out.println(filename[i]);
			str=filename[i].replace("[电影天堂]", "");
			System.out.println(str);
			oldf=new File("e://a//"+filename[i]);
			newf=new File("e://a//"+str);
			oldf.renameTo(newf);
		}
	 */
}
