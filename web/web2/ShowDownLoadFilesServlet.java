package cn.neusoft.usermanager.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/downloads")
public class ShowDownLoadFilesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		//要把downloads文件夹中的文件都要显示给客户端
		ServletContext context=request.getServletContext();//每一个web都会有一个唯一的上下文对象
		String path=context.getRealPath("/downloads");
		//要把该路径的字符串包装成一个文件对象，然后去遍历，
		File file=new File(path);
		File[] files=file.listFiles();
		out.println("<center><table border='1' width='70%' />");
		for(File f:files){
			String fname=f.getName();
			//要对文件名称进行处理，防止中文乱码以及请求编码问题
			String fname2=URLEncoder.encode(fname, "utf-8");
			out.println("<tr>");
			out.println("<td>"+fname+"</td><td><a href='download?fname="+fname2+"'>点击下载我</a></td>");
			out.println("</tr>");
		}
		out.println("</table></center>");
		System.out.println("path="+path);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
