package com.kaicom.servlet.respose;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/downFile")
public class DownFileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fileName");
		//完成文件下载
		//设置请求头
		String type = this.getServletContext().getMimeType(fileName);
		resp.setHeader("Content-Type", type);
		//解决中文乱码的问题
		String fileNameEncoding = URLEncoder.encode(fileName, "UTF-8");
		resp.setHeader("Content-Disposition", "attachment;filename="+fileNameEncoding);
		String realPath = this.getServletContext().getRealPath("/down/"+fileName);
		FileInputStream is = new FileInputStream(realPath);
		ServletOutputStream os = resp.getOutputStream();
		int len = 0 ;
		byte[] bytes = new byte[2014];
		while((len = is.read(bytes)) != -1){
			os.write(bytes,0,len);
		}
		is.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
