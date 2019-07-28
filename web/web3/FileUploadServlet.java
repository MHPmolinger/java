package com.neusoft.javaweb.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//ע��@MultipartConfig������ע��һ�������棬��ʾ���������ϴ��ģ�ֻ�м��˸�ע��ſ���ʹ��Part�������ϴ�����servlet3.0֮��������ṩ���ϴ�����
@WebServlet("/uploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out=response.getWriter();
		  //��ȡ�ϴ�������ͨ�ֶ�
		  String name=request.getParameter("name");
		  out.println(name+"<br>");
		  //�����ϴ��ֶΣ�ʹ��request.getParameter("uploadFile")�ǲ����Եģ�����Ҫʹ��Part����ſ���
		  //��ȡ��װ���ϴ��ֶε�Part����
		  Part part=request.getPart("uploadFile");
		  //ͨ����ȡpart���������Ϊcontent-disposition��ͷ����ȡ�ϴ��ļ�������
		  String uploadheader=part.getHeader("content-disposition");
		  System.out.println(uploadheader);
		  out.println("part.getHeader(\"content-disposition\"):="+uploadheader+"<br>");
		  //�������ַ�����Ŀ����Ҫ��ȡ���ϴ��ļ������ƣ���Ϊ����Ҫ�ڷ������˱���һ�����ƺ��ϴ��ļ�����һ�µ��ļ�
		  String filename=uploadheader.substring(uploadheader.lastIndexOf("\\")+1,uploadheader.length()-1);
		  System.out.println("filename="+filename);
		  //ʹ��part�����writer������ʵ���ϴ�
		  String uploadpath=request.getServletContext().getRealPath("/uploads");
		  System.out.println(uploadpath);
		  //������Ҫ�����ļ��ڷ��������Ƿ���ڣ��������������Ҫʹ��filename(1),filename(2)��������ʽ������
		  File targetFile=new File(uploadpath,filename);
		  //��ȡ�ļ��ĺ�׺�����ļ�������  ,����Ƶ16.avi,
		  String prefix=filename.substring(0, filename.indexOf("."));
		  String suffix=filename.substring(filename.indexOf(".")+1);
		  int n=1;
		  while(targetFile.exists()){
			  filename=prefix+"("+(n++)+")."+suffix;
			  targetFile=new File(uploadpath,filename);	  
		  }
		  part.write(uploadpath+File.separator+filename);
		 
		  out.println("�ϴ�["+filename+"]�ļ��ɹ���");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
