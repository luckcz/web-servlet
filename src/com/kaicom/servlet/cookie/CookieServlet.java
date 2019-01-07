package com.kaicom.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaicom.servlet.util.CookieUtil;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		Cookie cookie = CookieUtil.getCookie(cookies, "acceptTime");
		if(null != cookie){
			//代表不是第一次访问
			System.out.println("最大失效时间："+cookie.getMaxAge());
			System.out.println("可以访问的路径："+cookie.getPath());
			writer.print("上次访问时间为");
			writer.print("<h1>"+cookie.getValue()+"</h1>");
		}else{
			//代表是第一次访问
			writer.print("<h1>欢迎第一次访问</h1>");
		}
		Cookie newCookie = new Cookie("acceptTime", new Date().toLocaleString());
		/**
		 * 设置cookie的有效时间，以秒为单位，
		 * 如果有没有设置cookie的有效时间则关闭浏览器就直接销毁
		 * 如果设置了cookie的有效时间不管是否关闭浏览器只有时效到了就销毁
		 * 当然还有一种就是直接情况浏览器的缓存也会消除cookie
		 */
		newCookie.setMaxAge(40);
		String path = this.getServletContext().getContextPath() + "/cookie";
		/**
		 * 设置cookie的允许被访问路径，以及子路径都会允许被访问，
		 * 如果是/就带表tomcat服务器里面所有的应用都可以访问这个cookie
		 */
		newCookie.setPath(path);
		resp.addCookie(newCookie);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
