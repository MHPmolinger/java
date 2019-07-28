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
 * ���ܣ����ȫջ�������⣨���ܵģ�
 * @author neusoft102
 *
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding="UTF-8";//�����������õĳ�ʼ���ַ�����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("CharacterEncodingFilter.doFilter()");
		//���������Ӧ����ת���ɻ���Http�����Ӧ�Ķ���
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding(this.encoding);
		response.setContentType("text/html;charset="+this.encoding);
		response.setCharacterEncoding(this.encoding);
		chain.doFilter(new MyRequest(request), response);

	}
	//��ǿ���ģʽ��������Ҫ�ѱ���ǿ�Ķ�����Ϊ���췽���Ĳ������ݽ�����ͨ��Ϊ�˱���ô��ݹ�������Ҫ��ǿ�Ķ���������Ҫ����һ��ͬ���͵ĳ�Ա����
    class MyRequest extends HttpServletRequestWrapper{
          private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			     //��ȡ����ķ�ʽ
			String method=this.request.getMethod();
			if("POST".equalsIgnoreCase(method)){
				return this.request.getParameter(name);
			}else if("GET".equalsIgnoreCase(method)){
				//Ҫ���д���
				String value=this.request.getParameter(name);
				//Ҫ��value���д���
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
