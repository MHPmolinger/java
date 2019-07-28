package cn.zdxy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import cn.zdxy.dao.UserDao;
import cn.zdxy.domain.User;
import cn.zdxy.utils.WebUtils;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=null;
		UserDao udao=new UserDao();
		//�ж��û�ʱ���ǺϷ���
		user=udao.findUser(username, password);
		String message="";
		//����û�Ϊ�գ���ʾ�û������������
		if(user==null){
			message="�û������������";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
		//����û��ǺϷ��ģ����û���Ϣ���浽session�Ự��
		request.getSession().setAttribute("user", user);
		try{
			//����cookie,Ϊ�˰�ȫ������ǰ��û������û�����Чʱ����м��ܣ�
			int loginExpiresTime=Integer.parseInt(request.getParameter("loginExpiressTime"));
			long time=System.currentTimeMillis()+loginExpiresTime*1000;
			String mima=WebUtils.md5(username, time, password);
			String userinfo=username+":"+time+":"+mima;
			Cookie cookie=new Cookie("autologinCookie",userinfo);
			//����cookie����Чʱ��
			cookie.setMaxAge(loginExpiresTime);
			//����cookie�ķ���·��
			cookie.setPath(request.getContextPath());//Ҳ����javaweb_day13
			//��cookie���뵽response������һ�����͵��ͻ���
			response.addCookie(cookie);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		//������ת����messageҳ������
		request.setAttribute("message", "��¼�ɹ���");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
