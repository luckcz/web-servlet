<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	Cookie coo = null ;
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("userName")){
			coo = cookie;
		}
	}
	String userNameDecoder = "" ;
	if(null != coo){
		System.out.print("coo.getValue()-------------->"+coo.getValue());
		userNameDecoder = URLDecoder.decode(coo.getValue(),"UTF-8");
	}
%>
<body>
	<h1>欢迎<%=userNameDecoder%>登录........................</h1>
</body>
</html>