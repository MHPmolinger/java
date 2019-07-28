package cn.neusoft_ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/ValidateTypeServlet.do")
public class ValidateGoodsTypeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
		 String type=request.getParameter("goodsTypeId");
		 if(type.equals("1001")){
			 response.getWriter().print("<font color='red'>对不起,该编号已经被注册过了</font>");
		 }else{
			 response.getWriter().print("<font color='green'>编号通过验证</font>");
		 }
	}

	
}
