package com.kaicom.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("*****************登录拦截器初始化成功*********************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		HttpServletResponse resp = (HttpServletResponse)response;
		String userName = (String)session.getAttribute("userName");
		String requestURI = req.getRequestURI();
		System.out.println("requestURI--------------->"+requestURI);
		if(requestURI.contains("/login") || requestURI.contains("Image")){
			chain.doFilter(request, response);
		}else{
			if(userName != null){
				chain.doFilter(request, response);
			}else{
				System.out.println("******************被拦截了********************");
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("*****************登录拦截器销毁成功*********************");
	}

}
