package cn.zdxy.web.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class WordsFilter implements Filter {

	// 定义三个ArrayList集合分别用来保存禁用词，审核词和替换词
			private List<String> banWords=new ArrayList<String>();
			private List<String> auditWords=new ArrayList<String>();
			private List<String> replaceWords=new ArrayList<String>();
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//检查用户提交的数据时候包含禁用词，如果包含禁用次的话，请求就不可以放行了，之间返回给用户一个文明用词的信息
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String inputValue=request.getParameter(name);
			if(inputValue==null ||"".equals(inputValue.trim())){
				continue;
			}
			//用禁用词库来对用户的输入数据进行比对，看是否包含禁用词
			for(String regex:banWords){
				//使用正则表达式来进行匹配
				Pattern p=Pattern.compile(regex);//创建一个Pattern对象
				Matcher m=p.matcher(inputValue);//得到一个模式匹配器
				if(m.find()){
					//表示在用户的输入数据中包含了和正则表达式匹配的禁用词数据，
					request.setAttribute("message", "文章中包含了非法的禁用词汇，请文明用语！！");
					request.getRequestDispatcher("/words_message.jsp").forward(request, response);
					return ;
				}
			}
		}
		//程序运行到次，表示用户的输入数据中不包含禁用词数据,在放行前还用进行审核词和替换词的审查
		//在放行前要对request对象进行增强，复写getParameter方法，使用装饰器模式来对request对象
		//进行功能的增强（也可以使用动态代理），我们可以使用sun公司给我们提供的HttpServletRequestWrapper类
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
			//首先获取到用户输入的数据
			String inputValue=this.request.getParameter(name);
			//判断数据时候为空
			if(null==inputValue ||"".equals(inputValue.trim())){
				return null;
			}
			//对用户输入的数据进行审核词检查
			for(String regex:auditWords){
				Pattern p=Pattern.compile(regex);
				Matcher m=p.matcher(inputValue);
				if(m.find()){
					//获取用户输入的数据中与正则表达式匹配的数据
					String data=m.group();
					inputValue=inputValue.replaceAll(regex, "<font color='red'>"+data+"</font>");
				}
			}
			//还要对用户输入的数据进行替换词审查
			for(String regex:replaceWords){
				Pattern p=Pattern.compile(regex);
				Matcher m=p.matcher(inputValue);
				if(m.find()){
				    inputValue=inputValue.replaceAll(regex, "**********");
				}
			}
			return inputValue;
		}
		
		
    	
    }
	public void init(FilterConfig arg0) throws ServletException {
		
		try{
			//要在系统启动的时候去加载这些词库大全， 到对应的三个集合中来
			
			//得到当前的类路径信息
			String path=WordsFilter.class.getClassLoader().getResource("/").getPath();
			//创建文件对象
			File file=new File(path);
			//获取该目录下的所有.txt的文件，并把他们加载对对应的集合中来
			File[] files=file.listFiles();
			for(File f:files){
				if(!f.getName().endsWith(".txt")){
					continue;
				}
				//使用BufferedReader类读取数据内容
				BufferedReader br=new BufferedReader(new FileReader(f));
				String line=null;
				while((line=br.readLine())!=null){
					if(line.trim().equals("")){
						continue;
					}
					String[] values=line.trim().split("\\|");
					if(values.length!=2){//表示该数据不是符合要求的审核次数据
						continue;
					}
					if(values[1].trim().equals("1")){
						banWords.add(values[0].trim());
					}
					if(values[1].trim().equals("2")){
						auditWords.add(values[0].trim());
					}
					if(values[1].trim().equals("3")){
						replaceWords.add(values[0].trim());
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}

	}

}
