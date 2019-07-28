package cn.zdxy.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;


public class CacheFilter implements Filter {

	private FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		Enumeration e=this.config.getInitParameterNames();
//		while(e.hasMoreElements()){
//			String name=(String)e.nextElement();
//			Integer value=Integer.parseInt(this.config.getInitParameter(name));
//			
//		}
		//获取客户端的请求uri，
		String uri=request.getRequestURI();
		if(uri.endsWith(".js")){
			int value=Integer.parseInt(this.config.getInitParameter("js"));
			long expiresTime=System.currentTimeMillis()+value*30*24*60*60*1000;
			response.setDateHeader("expires", expiresTime);
			chain.doFilter(request, response);
		}else if(uri.endsWith(".css")){
			int value=Integer.parseInt(this.config.getInitParameter("css"));
			long expiresTime=System.currentTimeMillis()+3*60*1000;
			response.setDateHeader("expires", expiresTime);
			chain.doFilter(request, response);
		}else if(uri.endsWith(".jpg")){
			long value=Long.parseLong(this.config.getInitParameter("jpg"));
			System.out.println(value);
			long expiresTime=System.currentTimeMillis()+3*60*1000;
			System.out.println(expiresTime);
			response.setDateHeader("expires", expiresTime);
			chain.doFilter(request, response);
		}else{
			
			chain.doFilter(request, response);
		}
		
		
	}

	public void init(FilterConfig config) throws ServletException {
		this.config=config;
		
	}

	
}
