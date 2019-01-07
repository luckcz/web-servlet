package com.kaicom.servlet.request.dispatch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 重定向和请求转发的区别
 * 1.重定向的地址栏会发生变化，转发的地址栏不变
 * 2.重定向两次请求两次响应，转发一次请求一次响应
 * 3.重定向路径需要加工程名，转发的路径不需要加工程名
 * 4.重定向可以跳转到任意网站，转发只能在服务器内部进行转发
 */
//测试请求转发
@WebServlet("/a")
public class AServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		req.setAttribute("userName", userName);
		req.setAttribute("password", password);
		req.getRequestDispatcher("/b").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}
