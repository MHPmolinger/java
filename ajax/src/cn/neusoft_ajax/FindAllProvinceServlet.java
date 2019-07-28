package cn.neusoft_ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flexjson.JSONSerializer;
@WebServlet("/servlet/findProvinceServlet.do")
public class FindAllProvinceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.setContentType("text/json;charset=utf-8");
		  AddressDao dao=new AddressDao();
		  List<Province> list=dao.findAllProvinces();
		  JSONSerializer jsonSerializer=new JSONSerializer();
		  String json=jsonSerializer.exclude("citys").exclude("*.class").serialize(list);
		  response.getWriter().print(json);
	}

	
}
