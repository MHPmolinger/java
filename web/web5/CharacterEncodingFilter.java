package com.neusoft.javaweb.day07.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
/**
 * 功能：解决全栈乱码问题（万能的）
 * @author neusoft102
 *
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding="UTF-8";//用来保存配置的初始化字符编码
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("CharacterEncodingFilter.doFilter()");
		//把请求和响应对象转换成基于Http请求对应的对象
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding(this.encoding);
		response.setContentType("text/html;charset="+this.encoding);
		response.setCharacterEncoding(this.encoding);
		chain.doFilter(new MyRequest(request), response);

	}
	//增强设计模式，我们需要把被增强的对象作为构造方法的参数传递进来，通过为了保存该传递过来的需要增强的对象，我们需要定义一个同类型的成员变量
    class MyRequest extends HttpServletRequestWrapper{
          private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			     //获取请求的方式
			String method=this.request.getMethod();
			if("POST".equalsIgnoreCase(method)){
				return this.request.getParameter(name);
			}else if("GET".equalsIgnoreCase(method)){
				//要进行处理
				String value=this.request.getParameter(name);
				//要对value进行处理
				try {
					value=new String(value.getBytes("iso8859-1"),CharacterEncodingFilter.this.encoding);
					return value;
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return super.getParameter(name);
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			String method=request.getMethod();
			if("post".equalsIgnoreCase(method)){
				return this.request.getParameterMap();
			}else if("get".equalsIgnoreCase(method)){
				Map<String,String[]> map=this.request.getParameterMap();
				for(String name:map.keySet()){
					String[] values=map.get(name);
					for(int i=0;values!=null&&i<values.length;i++){
						try {
							values[i]=new String(values[i].getBytes("iso8859-1"),CharacterEncodingFilter.this.encoding);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return map;
			}
			return super.getParameterMap();
		}
		@Override
		public String[] getParameterValues(String name) {
			String method=request.getMethod();
			if("post".equalsIgnoreCase(method)){
				return this.request.getParameterValues(name);
			}else if("get".equalsIgnoreCase(method)){
				String[] values=this.request.getParameterValues(name);
				for(int i=0;values!=null&&i<values.length;i++){
					try {
						values[i]=new String(values[i].getBytes("iso8859-1"),CharacterEncodingFilter.this.encoding);
						return values;
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return super.getParameterValues(name);
		}
    	
		
    }
	@Override
	public void init(FilterConfig config) throws ServletException {

           String encoding=config.getInitParameter("encoding");
           if(encoding!=null&&!"".equals(encoding.trim())){
        	   this.encoding=encoding;
           }

	}

}
