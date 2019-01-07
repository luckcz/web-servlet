package com.kaicom.servlet.respose;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = "香港";
		/**
		 * 第一种解决浏览器乱码的问题
		 * resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-Type", "text/html;charset=utf-8");
			第二种解决方案
			resp.setContentType("text/html;charset=utf-8");
			一般直接使用第二种就好了
		 */
		/*resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=utf-8");*/
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(str);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
