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
//注解@MultipartConfig用来标注在一个类上面，表示用来处理上传的，只有加了该注解才可以使用Part对象处理上传，是servlet3.0之后给我们提供的上传技术
@WebServlet("/uploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out=response.getWriter();
		  //获取上传表单的普通字段
		  String name=request.getParameter("name");
		  out.println(name+"<br>");
		  //对于上传字段，使用request.getParameter("uploadFile")是不可以的，必须要使用Part对象才可以
		  //获取包装了上传字段的Part对象
		  Part part=request.getPart("uploadFile");
		  //通过获取part对象的名称为content-disposition的头来获取上传文件的名称
		  String uploadheader=part.getHeader("content-disposition");
		  System.out.println(uploadheader);
		  out.println("part.getHeader(\"content-disposition\"):="+uploadheader+"<br>");
		  //解析该字符串，目的是要获取该上传文件的名称，因为我们要在服务器端保存一个名称和上传文件名称一致的文件
		  String filename=uploadheader.substring(uploadheader.lastIndexOf("\\")+1,uploadheader.length()-1);
		  System.out.println("filename="+filename);
		  //使用part对象的writer方法来实现上传
		  String uploadpath=request.getServletContext().getRealPath("/uploads");
		  System.out.println(uploadpath);
		  //我们需要检查该文件在服务器端是否存在，如果存在我们需要使用filename(1),filename(2)这样的形式来处理
		  File targetFile=new File(uploadpath,filename);
		  //截取文件的后缀，及文件的名称  ,如视频16.avi,
		  String prefix=filename.substring(0, filename.indexOf("."));
		  String suffix=filename.substring(filename.indexOf(".")+1);
		  int n=1;
		  while(targetFile.exists()){
			  filename=prefix+"("+(n++)+")."+suffix;
			  targetFile=new File(uploadpath,filename);	  
		  }
		  part.write(uploadpath+File.separator+filename);
		 
		  out.println("上传["+filename+"]文件成功！");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
