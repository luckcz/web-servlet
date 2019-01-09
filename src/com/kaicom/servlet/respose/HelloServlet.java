package com.kaicom.servlet.respose;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> headerNames = req.getHeaderNames();
		System.out.println("******************************请求头*************************************");
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			System.out.println("key："+headerName+"--->value："+req.getHeader(headerName));
		}
		resp.addCookie(new Cookie("userName", "xuhanghang"));
		resp.setHeader("language", "china");
		resp.setHeader("language", "US");
		resp.addHeader("language", "open");
		resp.addHeader("language", "ARP");
		resp.setStatus(200);
		resp.setContentType("text/html;charset=UTF-8");
		/**
		 * resp.getOutputStream().write("你好啊，我在杭州".getBytes());
		resp.getWriter().write("你好，杭州");
		这两个响应输出流不能同时存在，不然报错   
		java.lang.IllegalStateException: getOutputStream() has already been called for this response
		 */
		resp.setCharacterEncoding("UTF-8");
		//resp.getOutputStream().write("你好啊，我在杭州".getBytes());
		resp.getWriter().write("你好，杭州");
		resp.getWriter().write(req.getContextPath());
		System.out.println("******************************hello world*************************************");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("******************************HelloServlet销毁了*************************************");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("******************************HelloServlet启动了*************************************");
		ServletConfig servletConfig = this.getServletConfig();
		System.out.println("getServletName----->"+servletConfig.getServletName());
		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		while(initParameterNames.hasMoreElements()){
			String initName = initParameterNames.nextElement();
			System.out.println("servlet 初始化参数："+initName+"     值："+servletConfig.getInitParameter(initName));
		}
		ServletContext servletContext = servletConfig.getServletContext();
		System.out.println("servletContext:项目路径"+servletContext.getContextPath());
		Enumeration<String> initParameterNames2 = servletContext.getInitParameterNames();
		while(initParameterNames2.hasMoreElements()){
			String initName = initParameterNames2.nextElement();
			System.out.println("web 初始化参数："+initName+"     值："+servletContext.getInitParameter(initName));
		}
	}
	
	public void reflex(){
		System.out.println("***********************通过反射执行了方法***********************");
	}
}
