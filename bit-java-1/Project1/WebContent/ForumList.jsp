<%@page import="com.bit.project1.ForumListSave"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 읽기</h2>
	<table cellpadding="1" border="1" width="800" height="500">
 	<c:forEach var="i" begin="0" end="${forum_list.listSize-1 }">
	<tr>
		 	<td>${forum_list.seqNo[i]}</td>
			<td><a href="WebTemplate.jsp?BODY_PATH=ForumItemView.jsp?Seq_No=${forum_list.seqNo[i] }">${forum_list.title[i]}</a></td>
			<td>${forum_list.writer[i]}</td>
			<td>${forum_list.wdate[i] }</td>
			<td>${forum_list.wtime[i] }</td>
	</tr>
	</c:forEach>
	</table>
	<c:if test="${forum_list.nextPage}">
	<a href="ForumList?Last_Code=${forum_list.seqNo[forum_list.listSize- 1] }">다음 페이</a>
	</c:if>
</body>
</html>