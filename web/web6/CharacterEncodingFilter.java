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
 *  �������Ҫ��ס���࣬��Ϊ�ڿ���������Ҫ���������������Ļ�
 *  һ���ǲ���filter������ģ�������ģ�巽������Ҽ�ס�ˣ��ڿ������ǵ�
 *  ��Ŀ��ֱ���������þͿ�����
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
		   //��ServletRequest��ServletResponse����ǿ��ת��ΪHttp���͵�
		   HttpServletRequest request=(HttpServletRequest)req;
		   HttpServletResponse response=(HttpServletResponse)resp;
		   //��ȡ�ͻ���ͨ��web.xml���õĲ��õı���
		    String value=config.getInitParameter("encoding");
		    if(value!=null){
		    	this.encoding=value;
		    }
		     //�öδ���ֻ�ܽ��post�������������⣬����get�����ǲ����Խ������ģ�
		     request.setCharacterEncoding(this.encoding);
		     response.setCharacterEncoding(this.encoding);
		     response.setContentType("text/html;charset=utf-8");
		     /*
		      * Ϊ����ǿĳ�����ĳ�������������������¼��ַ�����
		      * ��1��ʵ�ֽӿڻ�̳и��࣬Ȼ��ȥ��дҪ����ǿ�ķ���
		      * ��2������װ�����ģʽ
		      *     �Զ���һ����ʵ�ֺͱ���ǿ�������ͬ�Ľӿڻ���
		      *     �ѱ���ǿ�Ķ�����Ϊ�����һ����Ա����
		      *     ���幹�췽�������ݱ���ǿ����Ȼ�����ĳ�Ա������ֵ
		      *     ��дҪ��ǿ�ķ����Ϳ�����
		      *  ��3�����ö�̬����ķ�ʽ��������ǿ
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
			//һ���ǲ���get��ʽ���ύ��ʽ
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
