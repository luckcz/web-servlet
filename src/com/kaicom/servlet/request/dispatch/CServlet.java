package com.kaicom.servlet.request.dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/c")
public class CServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = (String)req.getAttribute("userName");
		String password = (String)req.getAttribute("password");
		String hobby = (String)req.getAttribute("hobby");
		System.out.println("userName-------->"+userName);
		System.out.println("password-------->"+password);
		System.out.println("hobby-------->"+hobby);
		req.removeAttribute("hobby");
		System.out.println("removeAttribute   hobby-------->"+req.getAttribute("hobby"));
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		if("张三".equals(userName) || "李四".equals(userName) || "王五".equals(userName)){
			if("12345678".equals(password)){
				writer.write("<center><h1>登录成功！！！！</h1></center></br>");
				writer.write("<center><h1>欢迎  "+userName+"</h1></center></br>");
			}else{
				writer.write("<center><h1>密码错误</h1></center>");
			}
		}else{
			writer.write("<center><h1>用户名不存在</h1></center>");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {};
}
