package cn.zdxy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zdxy.dao.UserDao;
import cn.zdxy.domain.User;
import cn.zdxy.utils.WebUtils;

public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//1.�ж��û�ʱ���ѵ�¼
		    User user=(User)request.getSession().getAttribute("user");
		    if(user!=null){
		    	chain.doFilter(request, response);
		    	return ;
		    }
		//2.����û�û�е�¼�����ж��û�ʱ�����¼��cookie��Ϣ��
		     Cookie[] cookies=request.getCookies();
		     Cookie autologinCookie=null;
		     for(Cookie c:cookies){
		    	 if(c.getName().equals("autologinCookie")){
		    		 autologinCookie=c;
		    		 System.out.println(c.getName());
		    	 }
		     }
		     
		
		//3.����û�û�д���¼��cookie��ֱ�ӷ���
		    if(autologinCookie==null){
		    	chain.doFilter(request, response);
		    	return;
		    }
		
		//4.����û�����cookie�����ȡcookie��ֵ�����ж��Ƿ���Ч
		    //��cookie��ֵ�ԡ��������зָ���һ���ַ���������
		   String[] values=autologinCookie.getValue().split("\\:");
		   
		
		//5.�����Ч����ֱ�ӷ���
		  //��ȡ�ڶ���Ԫ�أ�Ҳ������Чʱ�䣩
		   long expiresTime=Long.parseLong(values[1]);
		   System.out.println("expirexsTime:"+expiresTime);
		   if(System.currentTimeMillis()>expiresTime){
			   chain.doFilter(request, response);
			   return ;
		   }
		
		//6.�����Ч�����бȽ��û�����������Ϣʱ����Ч�������ݿ��еõ������������Ϣ����ƥ��
		
         String username=values[0].trim();
         System.out.println(username);
         String client_md5=values[2].trim();
         //����dao��ķ���ͨ���û�������������
         UserDao udao=new UserDao();
         String password=udao.findBynamePassword(username);
         String server_md5=WebUtils.md5(username, expiresTime, password);
         //�ȽϿͻ��˵�MD5�ͷ������˵�MD5ʱ�����
         if(client_md5.equals(server_md5)){
        	 System.out.println("client_md5=service_md5");
        	 user=udao.findUser(username, password);
        	 request.getSession().setAttribute("user", user);
        	 chain.doFilter(request, response);
        	 return;
         }else{
        	 System.out.println("client_md5!=service_md5");
        	 chain.doFilter(request, response);
        	 return ;
         }
         
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
