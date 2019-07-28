package cn.neusoft.usermanager.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.neusoft.usermanager.domain.Department;
import cn.neusoft.usermanager.utils.WebUtils;
@WebServlet(value={"/addDeptServlet"})
public class AddDeptServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		Department dept=WebUtils.request2Bean(request, Department.class);
		out.println(dept);
	}

	
}
