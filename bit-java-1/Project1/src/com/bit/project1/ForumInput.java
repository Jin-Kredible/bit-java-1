package com.bit.project1;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/ForumInput")
public class ForumInput extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String currentUrl = request.getParameter("current_url");
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("login_id");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		int rowNum = 0;

		if (id == null) {
			try {
				throw new Exception("로그인이 안됐습니다. 로그인 부탁드립니다");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("WebTemplate.jsp?BODY_PATH=PleaseLogIn.html");
			}
		} else {

			try {
				GregorianCalendar now = new GregorianCalendar();
				// Date now2 = new Date();
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				Context init = new InitialContext();
				DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
				conn = ds.getConnection();
				stmt = conn.createStatement();
				// Time wtime = (Time) now.getTime();

				rs = stmt.executeQuery("select count(*) as i from forum;");

				if (rs.next()) {
					int seqno = rs.getInt("i") + 1;
					rowNum = stmt.executeUpdate(
							"insert into forum(seqno, title, content, writer, wdate, wtime) values('" + seqno + "', '"
									+ title + "','" + content + "', '" + id + "',CURDATE(),CURTIME());");
				}

				if (rowNum < 1) {
					throw new Exception("입력된 정보가 없습니다");
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

			response.sendRedirect(currentUrl);
		}
	}
}
