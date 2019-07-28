package cn.neusoft_ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import flexjson.JSONSerializer;
@WebServlet("/servlet/findAllCityServlet.do")
public class FindAllCityServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.setContentType("text/xml;charset=utf-8");
		  AddressDao dao=new AddressDao();
		  String pid=request.getParameter("pid");
		  System.out.println("pid="+pid);
		  List<City> list=dao.findCitysByProviceId(pid);
		  XStream xstream=new XStream();
		  xstream.alias("citys", List.class);
		  xstream.alias("city", City.class);
		  xstream.omitField(Province.class, "province");
		  String xml=xstream.toXML(list);
		  response.getWriter().print(xml);
		 
	}
}
