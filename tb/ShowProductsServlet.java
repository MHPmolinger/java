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
 * MVC���ģʽ��
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
		   //����dao��Ĳ�ѯ����
		   List<Product> list=pdao.findAll();
		   //�Ѹü��ϱ��浽�������У�Ȼ������ת����һ����ʵҳ������
		   request.setAttribute("products", list);
		   //����ת����һ��ҳ��
		   RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/user/shows.jsp");
		   //Ҫ��ԭʼ���������Ӧ���󴫵ݹ�ȥ
		   dispatcher.forward(request, response);
	}

	
}
