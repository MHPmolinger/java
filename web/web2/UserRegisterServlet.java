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
 * @WebServlet��ʹ�ý��ܣ�
 *   ��1����ע������������ϵ�����ӳ�����ķ���·���ģ����úͻ���xml���÷�ʽ��һ����
 *   ��2�����Խ��ܣ�
 *        urlPatterns:���ַ����������ͣ�����ӳ������·���ģ����ַ�����ֵ����Ҫ�Է�б�ܿ�ͷ����ʾ�������Ŀ�ĸ�·����
 *            �����ú���xml�����еģ�url-pattern��ǩֵһ��
 *            <servlet-mapping>
 *               <servlet-name></servlet-name>
 *               <url-pattern>/path1</url-pattern>
 *            </servlet-mapping>
 *            <servlet-mapping>
 *               <servlet-name></servlet-name>
 *               <url-pattern>/path2</url-pattern>
 *            </servlet-mapping>
 *        value:�����Ե�ֵ���ַ����������ͣ����ú�urlPatterns����һ��������ӳ�����ķ���·���ģ�Ĭ����ʹ�ø����ԣ������Ժ�urlPatternsֻ��
 *        ʹ����һ��
 *        initParams:��������Servlet���õĳ�ʼ�����������ú�xml�����е�init-param��ǩ���ƣ������Ե�������WebInitParam�������ͣ�
 *        �����Ե�ֵҲ��Ҫʹ��ע��@WebInitParam��ָ����ʼ�����������ƺͶ�Ӧ��ֵ����ע��ľ����÷����£�
 *          @WebInitParam(name="����",value="��Ӧ������ֵ")
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
		//��ȡ���Ĳ���,����װ��ʵ���������
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
	    	message="<font size='35' color='green'>����û��ɹ���</font>";
	    }else{
	    	message="<font size='35' color='red'>����û�ʧ�ܣ�</font>";
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
