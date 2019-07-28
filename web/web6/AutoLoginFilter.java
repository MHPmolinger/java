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
		//1.判断用户时候已登录
		    User user=(User)request.getSession().getAttribute("user");
		    if(user!=null){
		    	chain.doFilter(request, response);
		    	return ;
		    }
		//2.如果用户没有登录，再判断用户时候带登录的cookie信息吧
		     Cookie[] cookies=request.getCookies();
		     Cookie autologinCookie=null;
		     for(Cookie c:cookies){
		    	 if(c.getName().equals("autologinCookie")){
		    		 autologinCookie=c;
		    		 System.out.println(c.getName());
		    	 }
		     }
		     
		
		//3.如果用户没有带登录的cookie则直接放行
		    if(autologinCookie==null){
		    	chain.doFilter(request, response);
		    	return;
		    }
		
		//4.如果用户带了cookie，则获取cookie的值，并判断是否有效
		    //把cookie的值对“：”进行分隔成一个字符串的数组
		   String[] values=autologinCookie.getValue().split("\\:");
		   
		
		//5.如果无效，则直接放行
		  //获取第二个元素（也就是有效时间）
		   long expiresTime=Long.parseLong(values[1]);
		   System.out.println("expirexsTime:"+expiresTime);
		   if(System.currentTimeMillis()>expiresTime){
			   chain.doFilter(request, response);
			   return ;
		   }
		
		//6.如果有效，还有比较用户名和密码信息时候有效，从数据库中得到加码的数据信息进行匹配
		
         String username=values[0].trim();
         System.out.println(username);
         String client_md5=values[2].trim();
         //调用dao层的服务通过用户名来查找密码
         UserDao udao=new UserDao();
         String password=udao.findBynamePassword(username);
         String server_md5=WebUtils.md5(username, expiresTime, password);
         //比较客户端的MD5和服务器端的MD5时候相等
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
