package com.neusoft.taobao.web.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.neusoft.taobao.dao.ProductDao;
import com.neusoft.taobao.domain.Product;
@WebServlet("/addProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Product p=new Product();
		p.setPno(request.getParameter("pid"));
		p.setPname(request.getParameter("pname"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setPdesc(request.getParameter("pdesc"));
		Part part=request.getPart("imagePath");
		String str=part.getHeader("content-disposition");
		System.out.println(str);
		String filename=str.substring(str.lastIndexOf("\\")+1,str.length()-1);
		//获取上传的路径
		String uplodPath=request.getServletContext().getRealPath("/images");
		String info="";
		try {
			part.write(uplodPath+File.separator+filename);
			p.setImagePath(filename);
			ProductDao dao=new ProductDao();
			boolean result=dao.save(p);
			if(result){
				info="添加商品成功！";
			}else{
				info="添加商品失败！";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="上传商品失败！";
		}
		//把info保存到请求域中，然后选择一个页面给管理员展现上传商品是否成功
		request.setAttribute("info", info);
		//请求转发
		request.getRequestDispatcher("/WEB-INF/jsp/manager/message.jsp").forward(request, response);
	}

	
}
