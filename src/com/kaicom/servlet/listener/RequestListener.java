package com.kaicom.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听request作用域

request的作用范围：请求响应后马上销毁  传递的参数 或者请求转发跳转数据传递  
写入HttpServletRequest   应用比较多
事件定义的三要素
 * 	1.事件源头
 * 	2.动作
 * 	3.触发回调（触发动作后调用什么东西  onclick="回调"）
 * 
 * 监听器
 * 	事件源头（HttpServletRequst，Httpsession，ServletContext）
 * 	动作 （生命周期阶段（对象产生 销毁），数据变化（SetAttribute removeAttribute））
 * 	回调
 *request的生命周期  浏览器发起请求 产生request对象  响应后 request 被销毁
 *
 *记住要去web.xml中去注册
 */
public class RequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request  监听器销毁了");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request  监听器创建了");
	}

}
