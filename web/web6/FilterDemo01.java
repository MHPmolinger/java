package cn.zdxy.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo01 implements Filter {

	private FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encoding=config.getInitParameter("encoding");
		System.out.println(encoding);
		String schoolname=config.getInitParameter("schoolname");
		System.out.println(schoolname);
		System.out.println("在执行目标servlet资源之前被执行！");
		response.getWriter().println("在执行目标servlet资源之前被执行！<br>");
		chain.doFilter(request, response);//把请求放行，到下一个过滤器或目标资源
		response.getWriter().println("在执行目标servlet资源之后被执行！<br>");
		System.out.println("在执行目标servlet资源之后被执行！");
	}

	public void init(FilterConfig config) throws ServletException {
		this.config=config;
		System.out.println("filter的init方法被调用了");
		Enumeration e=config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String value=config.getInitParameter(name);
			System.out.println(name+"="+value);
		}
	}

}
