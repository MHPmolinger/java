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

	//用来存放禁用词汇的
	private List<String> banWords= new ArrayList<String>();
	private List<String> checkWords=new ArrayList<String>();//审核词汇
	private List<String> replaceWords=new ArrayList<String>();//替换词
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
		//处理去掉中间空格问题
		StringBuilder sb1=new StringBuilder();
		for(int i=0;i<inputValue.trim().length();i++){
			if(inputValue.charAt(i)!=' '){
				sb1.append(inputValue.charAt(i));
			}
		}
		inputValue=sb1.toString();
		//判断帖子内容是否在禁用词里面
		for(String refex:banWords){
			Pattern pattern=Pattern.compile(refex);
			Matcher matcher=pattern.matcher(inputValue);
			if(matcher.find()){
				return "你的帖子内容包含费用不文明禁用词汇["+inputValue+"],请文明用语！";
				
			}
		}
		//在进行校验审核词汇
		for(String refex:checkWords){
			Pattern pattern=Pattern.compile(refex);
			Matcher matcher=pattern.matcher(inputValue);
			if(matcher.find()){
				return "<font color='red'>"+inputValue+"</font>";
				
			}
		}
		//再进行替换词
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
		// 在初始化方法中对各个集合进行初始化（文件内容读取）
		String path=WordsContentFilter.class.getClassLoader().getResource("/").getPath();
		File parentFile=new File(path);
		File[] files=parentFile.listFiles();
		for(File f:files){
			if(f.getName().endsWith(".txt")){
				try {
					BufferedReader br=new BufferedReader(new FileReader(f));
					String line=null;
					while((line=br.readLine())!=null){
						//对取得出来的数据进行分析
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
		//把该流进行包装
		//BufferedReader br=new BufferedReader(new InputStreamReader(in));
		

	}

}
