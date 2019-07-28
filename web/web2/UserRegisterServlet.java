package cn.neusoft.usermanager.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.neusoft.usermanager.dao.UserDao;
import cn.neusoft.usermanager.domain.User;
import cn.neusoft.usermanager.utils.WebUtils;
/**
 * @WebServlet的使用介绍：
 *   （1）该注解是添加在类上的用来映射对外的访问路径的，作用和基于xml配置方式是一样的
 *   （2）属性介绍：
 *        urlPatterns:是字符串数组类型，用来映射对外的路径的，该字符串的值必须要以反斜杠开头，表示相对于项目的跟路径，
 *            其作用和在xml配置中的，url-pattern标签值一致
 *            <servlet-mapping>
 *               <servlet-name></servlet-name>
 *               <url-pattern>/path1</url-pattern>
 *            </servlet-mapping>
 *            <servlet-mapping>
 *               <servlet-name></servlet-name>
 *               <url-pattern>/path2</url-pattern>
 *            </servlet-mapping>
 *        value:该属性的值是字符串数组类型，作用和urlPatterns作用一样，用来映射对外的访问路径的，默认是使用该属性，该属性和urlPatterns只能
 *        使用其一，
 *        initParams:用来给该Servlet配置的初始化参数，作用和xml配置中的init-param标签类似，该属性的类型是WebInitParam数组类型，
 *        该属性的值也需要使用注解@WebInitParam来指定初始化参数的名称和对应的值，该注解的具体用法如下：
 *          @WebInitParam(name="名称",value="对应的名称值")
 *        
 * @author neusoft102
 *
 */
@WebServlet(urlPatterns={"/register.do","/register"},initParams={@WebInitParam(name="name",value="lixiaoming"),@WebInitParam(name="age",value="40")})
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     //
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//获取表单的参数,并封装到实体对象中来
//		User user=new User();
//		String name=request.getParameter("name");
//		user.setName(name);
//		String gender=request.getParameter("gender");
//		user.setGender(gender);
//		String birthday=request.getParameter("birthday");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			user.setBirthday(sdf.parse(birthday));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String[] loves=request.getParameterValues("loves");
//		user.setLoves(WebUtils.stringArray2String(loves));
//		user.setXueli(request.getParameter("xueli"));
//	    user.setResume(request.getParameter("resume"));
	
		User user=WebUtils.request2Bean(request, User.class);
		System.out.println(user);
	    UserDao userDao=new UserDao();
	    boolean result=userDao.save(user);
	    String message="";
	    if(result){
	    	message="<font size='35' color='green'>添加用户成功！</font>";
	    }else{
	    	message="<font size='35' color='red'>添加用户失败！</font>";
	    }
	    out.println(message);
	    out.println("<br>");
	    ServletConfig config=this.getServletConfig();
	    Enumeration<String> em=config.getInitParameterNames();
	    while(em.hasMoreElements()){
	    	String key=em.nextElement();
	    	String value=config.getInitParameter(key);
	    	out.println(key+":="+value+"<br>");
	    }
	}

	
}
