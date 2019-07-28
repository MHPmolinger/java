package cn.zdxy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//��session�б����˹���Ա����Ϣ��ſ��Է���,����ֱ��������¼ҳ��
		if(request.getSession().getAttribute("manager")!=null){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/managerLogin.jsp").forward(request, response);
			return ;
			//response.sendRedirect("../managerLogin.jsp");
		}
		

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
