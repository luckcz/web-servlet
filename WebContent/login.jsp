<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${msg}</h5>
	<img alt="验证码" src="${pageContext.request.contextPath}/Image" onclick="changeImg();" id = "yzm">
	<a href = "javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
	<form action="${pageContext.request.contextPath}/login">
		用户名：<input type="text" name = "userName" value="${cookie.userName.value}"/></br>
		密码：<input type="text" name = "password" value="${cookie.password.value}"/></br>
		<input type="submit" value="提交">
	</form>
</body>
<script type="text/javascript">
	function changeImg(){
		var yzm = document.getElementById("yzm");
		console.log(yzm.getAttribute("src"));
		yzm.setAttribute("src","${pageContext.request.contextPath}/Image?t="+new Date())
	}
</script>
</html>