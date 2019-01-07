package com.kaicom.servlet.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaicom.servlet.util.CookieUtil;

/**
 * 注解的方式
 */
@WebServlet("/createServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getLocalAddr:"+request.getLocalAddr());
		System.out.println("getLocalPort:"+request.getLocalPort());
		System.out.println("getLocalName:"+request.getLocalName());
		System.out.println("getLanguage:"+request.getLocale().getLanguage());
		System.out.println("getRemoteAddr:"+request.getRemoteAddr());
		System.out.println("getRemoteHost:"+request.getRemoteHost());
		System.out.println("getRemotePort:"+request.getRemotePort());
		System.out.println("getMethod:"+request.getMethod());
		System.out.println("getRequestURI:"+request.getRequestURI());
		System.out.println("getRequestURL:"+request.getRequestURL());
		System.out.println("getQueryString:"+request.getQueryString());
		System.out.println("getProtocol:"+request.getProtocol());
		System.out.println("getContextPath:"+request.getContextPath());
		System.out.println("getServletPath:"+request.getServletPath());
		System.out.println("getServerName:"+request.getServerName());
		System.out.println("getServerPort:"+request.getServerPort());
		System.out.println("getScheme:"+request.getScheme());
		System.out.println("getContentType:"+request.getContentType());
		System.out.println("getCharacterEncoding:"+request.getCharacterEncoding());
		System.out.println("getParameter:"+request.getParameter("user"));
		System.out.println("getParameterValues:"+Arrays.toString(request.getParameterValues("user")));
		Set<String> keySet = request.getParameterMap().keySet();
		/**
		 * 解决获取参数中文乱码问题
		 * request.setCharacterEncoding("UTF-8");   这种方式只支持post请求
		 * String hobby = request.getParameter("hobby");
		hobby = new String(hobby.getBytes("ISO-8859-1"),"UTF-8");  这种都可以
		 */
		for(String str : keySet){
			System.out.println("key:"+str);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext servletContext = this.getServletContext();
		System.out.println("项目路径"+servletContext.getContextPath());
		Enumeration<String> initParameterNames2 = servletContext.getInitParameterNames();
		while(initParameterNames2.hasMoreElements()){
			String initName = initParameterNames2.nextElement();
			System.out.println("web 初始化参数："+initName+"     值："+servletContext.getInitParameter(initName));
		}
		Cookie cookie = CookieUtil.getCookie(request.getCookies(), "acceptTime");
		if(null != cookie){
			System.out.println("访问时间"+cookie.getValue());
		}else{
			System.out.println("acceptTime cookie已经销毁");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
