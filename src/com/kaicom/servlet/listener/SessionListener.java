package com.kaicom.servlet.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * session作用域范围：数据使用有状态的  不同的用户拥有不同的数据  写入HttpSession
 */
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession hs=se.getSession();
		System.out.println("产生Session"+hs.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁");
	}
}
