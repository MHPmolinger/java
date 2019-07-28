package com.neusoft.javaweb.day07.web.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns={"/contentServlet"})
public class WordsContentFilter implements Filter {

	//������Ž��ôʻ��
	private List<String> banWords= new ArrayList<String>();
	private List<String> checkWords=new ArrayList<String>();//��˴ʻ�
	private List<String> replaceWords=new ArrayList<String>();//�滻��
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
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
		
		
		if(inputValue==null||"".equals(inputValue.trim())){
			return "";
		}
		//����ȥ���м�ո�����
		StringBuilder sb1=new StringBuilder();
		for(int i=0;i<inputValue.trim().length();i++){
			if(inputValue.charAt(i)!=' '){
				sb1.append(inputValue.charAt(i));
			}
		}
		inputValue=sb1.toString();
		//�ж����������Ƿ��ڽ��ô�����
		for(String refex:banWords){
			Pattern pattern=Pattern.compile(refex);
			Matcher matcher=pattern.matcher(inputValue);
			if(matcher.find()){
				return "����������ݰ������ò��������ôʻ�["+inputValue+"],���������";
				
			}
		}
		//�ڽ���У����˴ʻ�
		for(String refex:checkWords){
			Pattern pattern=Pattern.compile(refex);
			Matcher matcher=pattern.matcher(inputValue);
			if(matcher.find()){
				return "<font color='red'>"+inputValue+"</font>";
				
			}
		}
		//�ٽ����滻��
		for(String refex:replaceWords){
			Pattern pattern=Pattern.compile(refex);
			Matcher matcher=pattern.matcher(inputValue);
			if(matcher.find()){
				StringBuilder sb=new StringBuilder();
				for(int i=1;i<=inputValue.length();i++){
					sb.append("*");
				}
				return sb.toString();
				
			}
		}
		return super.getParameter(name);
	}
	 
	   
   }
	@Override
	public void init(FilterConfig config) throws ServletException {
		// �ڳ�ʼ�������жԸ������Ͻ��г�ʼ�����ļ����ݶ�ȡ��
		String path=WordsContentFilter.class.getClassLoader().getResource("/").getPath();
		File parentFile=new File(path);
		File[] files=parentFile.listFiles();
		for(File f:files){
			if(f.getName().endsWith(".txt")){
				try {
					BufferedReader br=new BufferedReader(new FileReader(f));
					String line=null;
					while((line=br.readLine())!=null){
						//��ȡ�ó��������ݽ��з���
						String[] array=line.trim().split("\\|");
						if(array.length==2){
							System.out.println("line="+line);
							if(array[1].trim().equals("1")){
								banWords.add(array[0].trim());
							}else if(array[1].trim().equals("2")){
								checkWords.add(array[0]);
							}else if(array[1].trim().equals("3")){
								replaceWords.add(array[0]);
							}
							
						}
						
					}
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		//�Ѹ������а�װ
		//BufferedReader br=new BufferedReader(new InputStreamReader(in));
		

	}

}
