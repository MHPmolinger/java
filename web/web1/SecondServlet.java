package cn.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  �����κ�����ʱ��Servlet ����һ�η���ʱ�����г�ʼ��
 *  service()��������д�Ļ�   ������жϵ�����doGet ������doPost����
 *  ���� action���д����Servlet  ��ô method ��get ����doGet����
 *                               method ��post ����doPost����
 *  ��������ֹͣ  ���� ��������ʱ  ������Servlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SecondServlet() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("second->init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("second->destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second->service()");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second->doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second->doPost()");
	}

}
