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
		//Ҫ��downloads�ļ����е��ļ���Ҫ��ʾ���ͻ���
		ServletContext context=request.getServletContext();//ÿһ��web������һ��Ψһ�������Ķ���
		String path=context.getRealPath("/downloads");
		//Ҫ�Ѹ�·�����ַ�����װ��һ���ļ�����Ȼ��ȥ������
		File file=new File(path);
		File[] files=file.listFiles();
		out.println("<center><table border='1' width='70%' />");
		for(File f:files){
			String fname=f.getName();
			//Ҫ���ļ����ƽ��д�����ֹ���������Լ������������
			String fname2=URLEncoder.encode(fname, "utf-8");
			out.println("<tr>");
			out.println("<td>"+fname+"</td><td><a href='download?fname="+fname2+"'>���������</a></td>");
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
