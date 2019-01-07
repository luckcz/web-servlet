package com.kaicom.servlet.listener;

import javax.servlet.ServletContextEvent;
/**
 * ServletContext作用域范围：当项目重新发布或者关闭服务器时销毁  所有的servlet都需要共享  
 * 数据需要保留时间很长  写入ServletContext
 */
public class ServletContextListener implements javax.servlet.ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("上下文对象创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("上下文对象销毁");
	}


}
