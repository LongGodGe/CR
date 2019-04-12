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
	//当servle销毁时候调用
	//当服务器关闭的时候
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy.....");
	}
	@Override
	//init servlet创建时调用
	//默认：第一次访问时创建
	//通过配置可以设置服务器一启动的时候创建对象
	//init 可以获取web。xml里面的值
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init....");
		String name = config.getServletName();
		System.out.println("servletname="+name);
		String initb = config.getInitParameter("abc");
		System.out.println(initb);
	}

	@Override
	//service 每一次发送请求就调用，发送一次调用一次
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello,servlet");
		HttpServletResponse hsp=(HttpServletResponse) res;
		hsp.getWriter().write("hello");
	}

	
}
