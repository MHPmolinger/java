package cn.neusoft.usermanager.web.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class DownLoadFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ���ݹ�����Ҫ���ص��ļ�����
		String filename=request.getParameter("fname");
		filename=new String(filename.getBytes("iso8859-1"),"utf-8");
		
		System.out.println(filename);
		//�ڷ������˲��Ҹ��ļ��Ƿ����
		String path=request.getServletContext().getRealPath("/downloads");
		File targetFile=new File(path,filename);
		if(targetFile.exists()){//��ʾ���ڣ����Ǿ�Ҫ��������
			System.out.println("�ļ����ڣ�");
			//�������ص�ͷ��Ϣ��Ҳ�����õ�����ش�һ���Ի������ش���
			String[] array=filename.trim().split("\\p{Blank}");
			String filename2=filename;
			if(array.length>0){
				filename2="";
				for(String str:array){
					filename2+=str.trim();
				}
			}
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename2, "utf-8"));
			//������ת�������Ŀ���
			BufferedInputStream bin=new BufferedInputStream(new FileInputStream(targetFile));
			//Ҫ�Ѷ�����������д���ͻ���
			OutputStream out=response.getOutputStream();
			//PrintWriter out2=response.getWriter();
			BufferedOutputStream bout=new BufferedOutputStream(out);
			byte[] buff=new byte[1024];
			int len=-1;
			while((len=bin.read(buff))>0){
				bout.write(buff, 0, len);
			}
			//�Ƿ���Դ
			bout.close();
			bin.close();
			out.close();
		    //response.getWriter().println("�����ļ�["+filename+"]�ɹ���");
			System.out.println("�����ļ�["+filename+"]�ɹ���");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
