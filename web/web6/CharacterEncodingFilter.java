package cn.zdxy.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *  请大家务必要记住该类，因为在开发中我们要解决中文乱码问题的话
 *  一定是采用filter来解决的，这是以模板方法，大家记住了，在开发真是的
 *  项目中直接拉过来用就可以了
 * @author Administrator
 *
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig config;
	private String encoding="UTF-8";
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		   //把ServletRequest和ServletResponse参数强制转化为Http类型的
		   HttpServletRequest request=(HttpServletRequest)req;
		   HttpServletResponse response=(HttpServletResponse)resp;
		   //获取客户端通过web.xml配置的采用的编码
		    String value=config.getInitParameter("encoding");
		    if(value!=null){
		    	this.encoding=value;
		    }
		     //该段代码只能解决post的请求乱码问题，对于get请求还是不可以解决乱码的，
		     request.setCharacterEncoding(this.encoding);
		     response.setCharacterEncoding(this.encoding);
		     response.setContentType("text/html;charset=utf-8");
		     /*
		      * 为了增强某个类的某个方法功能我们有以下几种方法：
		      * （1）实现接口或继承该类，然后去复写要被增强的方法
		      * （2）采用装饰设计模式
		      *     自定义一个类实现和被增强对象的相同的接口或类
		      *     把被增强的对象作为该类的一个成员变量
		      *     定义构造方法并传递被增强对象，然后给类的成员变量赋值
		      *     复写要增强的方法就可以了
		      *  （3）采用动态代理的方式来进行增强
		      */
		    chain.doFilter(new MyRequest(request), response);
		    

	}
    class MyRequest extends HttpServletRequestWrapper{
         private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			String inputValue=this.request.getParameter(name);
			if(inputValue==null ||inputValue.trim().equals("")){
				return null;
			}
			if(this.request.getMethod().equalsIgnoreCase("post")){
				return inputValue;
			}
			//一定是采用get方式的提交方式
			try {
				inputValue=new String(inputValue.getBytes("iso8859-1"),encoding);
				return inputValue;
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
    	
    }
	public void init(FilterConfig config) throws ServletException {
		this.config=config;

	}

}
