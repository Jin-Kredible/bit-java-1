<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Logout" method="post" onsubmit="current_url.value = window.location.href">
안녕하세요, ${sessionScope.login_id }님 <br/>
	<input type="hidden" name="current_url">
	<input type="submit" value="로그아웃">
	</form>
</body>
</html>