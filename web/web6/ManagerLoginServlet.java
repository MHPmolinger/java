package cn.zdxy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String managerName=request.getParameter("managerName");
		String password=request.getParameter("password");
		
		if("lixiaoming".equals(managerName)&& "123456".equals(password)){
			//��ʾ�ɹ���¼���ѺϷ����û���Ϣ���浽session�У�
			request.getSession().setAttribute("manager", managerName);
			request.getRequestDispatcher("/manager/index.jsp").forward(request, response);
		}else{
			response.sendRedirect("/javaweb_day13/managerLogin.jsp");
		}
	}

}
