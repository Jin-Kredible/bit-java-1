package com.bit.project1;

import java.io.*;
import java.sql.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/SignUp")
public class SingUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("여긴 넘어오니?");
		request.setCharacterEncoding("UTF-8");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String address = request.getParameter("address");
		if (id == null || password == null || gender == null) {
			try {
				response.sendRedirect("WebTemplate.jsp?BODY_PATH=MissingInfo.html");
				throw new Exception("회원님의 정보를 입력 부탁드립니다");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			try {
				Context init = new InitialContext();
				DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
				conn = ds.getConnection();
				if (conn == null) {
					throw new Exception("데이터베이스에 연결할 수 없습니다");
				}
				stmt = conn.createStatement();

				// String query = String.format;
				int s = stmt.executeUpdate("insert into userinfo(id, pw, gender, phone1, phone2, address) values('" + id
						+ "', '" + password + "', '" + gender + "', '" + phone1 + "', '" + phone2 + "', '" + address
						+ "');");
				// System.out.println(s);
				if (s < 1) {
					throw new ServletException("데이터를 다시 입력해주세요");
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
			response.sendRedirect("LoginSuccessPage.html");
		}
	}
}
