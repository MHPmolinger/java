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

	// ��������ArrayList���Ϸֱ�����������ôʣ���˴ʺ��滻��
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
		//����û��ύ������ʱ��������ôʣ�����������ôεĻ�������Ͳ����Է����ˣ�֮�䷵�ظ��û�һ�������ôʵ���Ϣ
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String)e.nextElement();
			String inputValue=request.getParameter(name);
			if(inputValue==null ||"".equals(inputValue.trim())){
				continue;
			}
			//�ý��ôʿ������û����������ݽ��бȶԣ����Ƿ�������ô�
			for(String regex:banWords){
				//ʹ��������ʽ������ƥ��
				Pattern p=Pattern.compile(regex);//����һ��Pattern����
				Matcher m=p.matcher(inputValue);//�õ�һ��ģʽƥ����
				if(m.find()){
					//��ʾ���û������������а����˺�������ʽƥ��Ľ��ô����ݣ�
					request.setAttribute("message", "�����а����˷Ƿ��Ľ��ôʻ㣬�����������");
					request.getRequestDispatcher("/words_message.jsp").forward(request, response);
					return ;
				}
			}
		}
		//�������е��Σ���ʾ�û������������в��������ô�����,�ڷ���ǰ���ý�����˴ʺ��滻�ʵ����
		//�ڷ���ǰҪ��request���������ǿ����дgetParameter������ʹ��װ����ģʽ����request����
		//���й��ܵ���ǿ��Ҳ����ʹ�ö�̬���������ǿ���ʹ��sun��˾�������ṩ��HttpServletRequestWrapper��
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
			//���Ȼ�ȡ���û����������
			String inputValue=this.request.getParameter(name);
			//�ж�����ʱ��Ϊ��
			if(null==inputValue ||"".equals(inputValue.trim())){
				return null;
			}
			//���û���������ݽ�����˴ʼ��
			for(String regex:auditWords){
				Pattern p=Pattern.compile(regex);
				Matcher m=p.matcher(inputValue);
				if(m.find()){
					//��ȡ�û��������������������ʽƥ�������
					String data=m.group();
					inputValue=inputValue.replaceAll(regex, "<font color='red'>"+data+"</font>");
				}
			}
			//��Ҫ���û���������ݽ����滻�����
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
			//Ҫ��ϵͳ������ʱ��ȥ������Щ�ʿ��ȫ�� ����Ӧ��������������
			
			//�õ���ǰ����·����Ϣ
			String path=WordsFilter.class.getClassLoader().getResource("/").getPath();
			//�����ļ�����
			File file=new File(path);
			//��ȡ��Ŀ¼�µ�����.txt���ļ����������Ǽ��ضԶ�Ӧ�ļ�������
			File[] files=file.listFiles();
			for(File f:files){
				if(!f.getName().endsWith(".txt")){
					continue;
				}
				//ʹ��BufferedReader���ȡ��������
				BufferedReader br=new BufferedReader(new FileReader(f));
				String line=null;
				while((line=br.readLine())!=null){
					if(line.trim().equals("")){
						continue;
					}
					String[] values=line.trim().split("\\|");
					if(values.length!=2){//��ʾ�����ݲ��Ƿ���Ҫ�����˴�����
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
