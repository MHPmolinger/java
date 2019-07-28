package com.neusoft.javaweb.day07.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contentServlet")
public class ContentServelt extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String content=request.getParameter("content");
		    request.setAttribute("info", content);
		    request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	
}
