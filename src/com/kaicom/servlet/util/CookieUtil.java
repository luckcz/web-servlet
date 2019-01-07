package com.kaicom.servlet.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Cookie getCookie(Cookie[] cookies ,String cookieName){
		if(null != cookies && cookies.length > 0 && null != cookieName && !cookieName.trim().equals("")){
			for(Cookie cookie : cookies){
				if(cookieName.equals(cookie.getName())){
					return cookie ;
				}
			}
		}
		return null ;
	}
}
