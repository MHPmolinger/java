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
		//获取传递过来的要下载的文件名称
		String filename=request.getParameter("fname");
		filename=new String(filename.getBytes("iso8859-1"),"utf-8");
		
		System.out.println(filename);
		//在服务器端查找该文件是否存在
		String path=request.getServletContext().getRealPath("/downloads");
		File targetFile=new File(path,filename);
		if(targetFile.exists()){//表示存在，我们就要出来下载
			System.out.println("文件存在！");
			//设置下载的头信息，也就是让点击下载打开一个对话框下载窗口
			String[] array=filename.trim().split("\\p{Blank}");
			String filename2=filename;
			if(array.length>0){
				filename2="";
				for(String str:array){
					filename2+=str.trim();
				}
			}
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename2, "utf-8"));
			//把下载转换成流的拷贝
			BufferedInputStream bin=new BufferedInputStream(new FileInputStream(targetFile));
			//要把读出来的内容写给客户端
			OutputStream out=response.getOutputStream();
			//PrintWriter out2=response.getWriter();
			BufferedOutputStream bout=new BufferedOutputStream(out);
			byte[] buff=new byte[1024];
			int len=-1;
			while((len=bin.read(buff))>0){
				bout.write(buff, 0, len);
			}
			//是否资源
			bout.close();
			bin.close();
			out.close();
		    //response.getWriter().println("下载文件["+filename+"]成功！");
			System.out.println("下载文件["+filename+"]成功！");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
