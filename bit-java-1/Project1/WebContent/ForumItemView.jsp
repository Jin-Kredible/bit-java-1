<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	int seqno = Integer.parseInt(request.getParameter("Seq_No"));
Context init = new InitialContext();	
DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
Connection conn = ds.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from forum where seqno='"+ seqno+"';");
String title =null;
String writer =null;
String wdate =null;
String wtime =null;
String content =null;

if(rs.next()){
title = rs.getString("title");
writer = rs.getString("writer");
wdate = rs.getString("wdate");
wtime = rs.getString("wtime");
content = rs.getString("content");
}
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>게시글 읽기</h4>
	[제목] <%= title %>
	[작성자] <%= writer %>
	[작성일자] <%=wdate %> <%=wtime %><br/>
	-----------------------------------------------------------------------<br/>
	<%= content %>
</body>
</html>