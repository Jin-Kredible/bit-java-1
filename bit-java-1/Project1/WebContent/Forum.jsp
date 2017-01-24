<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ForumInput" method="post" onsubmit="current_url.value=window.location.href">
	제목 : <input type="text" name="title" align="middle"><br>
	<textarea rows="30" cols="100" name="content"></textarea><br>
	<input type="submit" value="확인">
	<input type="reset" value="취소"><br>
	<input type="hidden" name="current_url">
</form>

</body>
</html>