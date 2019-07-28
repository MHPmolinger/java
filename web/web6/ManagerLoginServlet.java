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
			//表示成功登录，把合法的用户信息保存到session中，
			request.getSession().setAttribute("manager", managerName);
			request.getRequestDispatcher("/manager/index.jsp").forward(request, response);
		}else{
			response.sendRedirect("/javaweb_day13/managerLogin.jsp");
		}
	}

}
