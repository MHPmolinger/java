package cn.neusoft_ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flexjson.JSONSerializer;
@WebServlet("/servlet/JSONServlet.do")
public class FlexJsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		 GoodsTypeDao dao=new GoodsTypeDao();
		 List<GoodsType> list=dao.findAll();
		 JSONSerializer jsonSerializer=new JSONSerializer();
		 String jsonContext=jsonSerializer.exclude("class").serialize(list);
		 response.getWriter().print(jsonContext);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
