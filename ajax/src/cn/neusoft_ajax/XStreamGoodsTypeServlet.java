package cn.neusoft_ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
@WebServlet("/servlet/gt.do")
public class XStreamGoodsTypeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		GoodsTypeDao dao=new GoodsTypeDao();
		List<GoodsType> list=dao.findAll();
		System.out.println(list.size()+"--------");
		XStream xstream=new XStream();
		//xstream.alias("gts", List.class);
		xstream.alias("goodsType", GoodsType.class);
		String xml=xstream.toXML(list);
		System.out.print(xml);
		response.getWriter().print(xml);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
		
	}

	
}
