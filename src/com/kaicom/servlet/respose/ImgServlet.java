package com.kaicom.servlet.respose;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/Image")
public class ImgServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//绘制验证码
		int height = 250 ;
		int width = 500 ;
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		
		//创建图片
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		
		//获取画板
		Graphics graphics = image.getGraphics();
		
		//填充一个矩形
		graphics.setColor(Color.BLACK);
		graphics.fillRect(1, 1, width-2, height-2);
		
		//设置字体
		graphics.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));
		
		//编写随机数
		for(int i = 0 ; i < 4 ; i++){
			//设置颜色随机数
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			//获取随机数
			int index = random.nextInt(data.length());
			String str = data.substring(index, index + 1);
			
			//写入
			graphics.drawString(str, width/6 * (i + 1), height/2);
			
		}
		
		//加干扰线
		for(int i = 0 ; i < 150 ; i++){
			//设置随机颜色
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			//随机绘制
			graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
			//随机点
			graphics.drawOval(random.nextInt(width), random.nextInt(height), 2,2);
		}
		
		
		//将图片响应给浏览器
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
