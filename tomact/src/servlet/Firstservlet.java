package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Firstservlet implements Servlet {

	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//��servle����ʱ�����
	//���������رյ�ʱ��
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy.....");
	}
	@Override
	//init servlet����ʱ����
	//Ĭ�ϣ���һ�η���ʱ����
	//ͨ�����ÿ������÷�����һ������ʱ�򴴽�����
	//init ���Ի�ȡweb��xml�����ֵ
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init....");
		String name = config.getServletName();
		System.out.println("servletname="+name);
		String initb = config.getInitParameter("abc");
		System.out.println(initb);
	}

	@Override
	//service ÿһ�η�������͵��ã�����һ�ε���һ��
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello,servlet");
		HttpServletResponse hsp=(HttpServletResponse) res;
		hsp.getWriter().write("hello");
	}

	
}
