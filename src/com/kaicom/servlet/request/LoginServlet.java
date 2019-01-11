package com.kaicom.servlet.request;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		resp.setContentType("text/html;charset=utf-8");
		if("张三".equals(userName)){
			if("123".equals(password)){
				String userNameEncoder = URLEncoder.encode(userName,"UTF-8");
				System.out.println("userNameEncoder--------------->"+userNameEncoder);
				System.out.println("开始设置了cookie");
				Cookie cookie = new Cookie("userName", userNameEncoder);
				cookie.setMaxAge(30);
				cookie.setPath(req.getContextPath());
				resp.addCookie(cookie);
				Cookie cookie2 = new Cookie("password", password);
				cookie2.setMaxAge(30);
				cookie2.setPath(req.getContextPath());
				resp.addCookie(cookie2);
				System.out.println("设置cookie完毕");
				HttpSession session = req.getSession();
				session.setAttribute("userName", userName);
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			}else{
				req.setAttribute("msg", "密码错误");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("msg", "用户名错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
