<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<a href="WebTemplate.jsp"><h1 align="middle">Jin's SecondHand Luxury Products</h1></a>
<center><table border="3" cellpadding="3" width=800>
	<center><tr align="center">
		<td width="80%">
		<c:choose>
					<c:when test="${sessionScope.login_id==null }">
						<jsp:include page="LoginWindow.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="LogoutWindow.jsp" />
					</c:otherwise>
		</c:choose><br>
		<br>
		<a href="WebTemplate.jsp?BODY_PATH=HomePage.html">홈</a> &nbsp  &nbsp
		<a href="SignUpPage.html">회원가입</a>&nbsp  &nbsp
		<a href="WebTemplate.jsp?BODY_PATH=Intro.html">회사소개</a> &nbsp  &nbsp
		<a href="ForumList">게시판 글읽기</a> &nbsp  &nbsp
		<a href="WebTemplate.jsp?BODY_PATH=Forum.jsp">게시판 글쓰기</a> &nbsp  &nbsp
		<a href="Question.html">Q&A</a> &nbsp  &nbsp
		<input type="hidden" name="current_url">
		</td>
	</center>
	</tr>
	<tr>
		<td height=800>
		<c:choose>
		<c:when test="${param.BODY_PATH==null }">
			<jsp:include page="HomePage.html"/>
		</c:when>
		<c:otherwise>
		<jsp:include page="${param.BODY_PATH }" />
		</c:otherwise>
		</c:choose>
		</td>
	</tr>
</table>
</center>
</body>
</html>	