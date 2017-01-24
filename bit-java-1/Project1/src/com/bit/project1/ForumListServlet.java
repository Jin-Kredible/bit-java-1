package com.bit.project1;

import java.io.*;
import java.sql.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/ForumList")
public class ForumListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ForumListSave list = new ForumListSave();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int lastCode=0;
		
		
		
		String lastCode0 = request.getParameter("Last_Code");

		if(lastCode0==null){
			lastCode = 1000000;
		} else {
			lastCode= Integer.parseInt(lastCode0);
		}

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn==null){
				throw new Exception("데이터 베이스에 연결 안됨");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from forum where seqno < " + lastCode + " order by seqno desc;");
	
			for (int i = 0; i < 5; i++) {
				if(rs.next()){
					System.out.println(rs);
						list.setSeqNo(i, rs.getInt("seqno"));
						list.setTitle(i, rs.getString("title"));
						list.setContent(i, rs.getString("content"));
						list.setWriter(i, rs.getString("writer"));
						list.setWdate(i, rs.getString("wdate"));
						list.setWtime(i, rs.getString("wtime"));
						//System.out.println(list[i].seqno + ", " + list[i].title);
					}
			}
			if(!rs.next()){
				list.setNextPage(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		request.setAttribute("forum_list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=ForumList.jsp");
		dispatcher.forward(request, response);
	}
}
