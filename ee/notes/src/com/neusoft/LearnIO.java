package com.neusoft;

public class LearnIO {
/**
 * 1��Java���Զ��� ������������ļ��Ĳ���   ʹ�� IO����������
 *   I���� input ����     ָ����  �������ݶ��� �ڴ�
 *   O���� output ���  ָ����  �ڴ��������� ������
 * 2��������ȷһ������ļ����� Ҳ��  ���紫������ Ҳ�� �ײ㶼�ǽ���Щ����ת����  �ֽ��� ���в������̡�
 * 3��Java�����ļ���һ�� ���� ������ InputStream
 * 4��File��
 
	
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
			str=filename[i].replace("[��Ӱ����]", "");
			System.out.println(str);
			oldf=new File("e://a//"+filename[i]);
			newf=new File("e://a//"+str);
			oldf.renameTo(newf);
		}
	 */
}
