package com.neusoft.taobao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.taobao.dao.ProductDao;
import com.neusoft.taobao.domain.Product;
/**
 * MVC设计模式：
 *   Model:domain->dao
 *   View:jsp
 *   Controller:Servlet
 */
@WebServlet("/showProductsServelt")
public class ShowProductsServlet extends HttpServlet {
     private ProductDao pdao=new ProductDao();
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //调用dao层的查询服务
		   List<Product> list=pdao.findAll();
		   //把该集合保存到请求域中，然后请求转发到一个现实页面上来
		   request.setAttribute("products", list);
		   //请求转发到一个页面
		   RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/user/shows.jsp");
		   //要把原始的请求和响应对象传递过去
		   dispatcher.forward(request, response);
	}

	
}
