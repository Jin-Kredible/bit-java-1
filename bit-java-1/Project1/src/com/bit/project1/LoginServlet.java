package com.bit.project1;

import java.io.*;
import java.sql.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		String pw = null;
		String currentUrl = request.getParameter("current_url");
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn==null){
				throw new Exception("데이터에 연결할 수 없습니다");
			}
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from userinfo where id ='"+ id + "';");
			
			if(rs.next()){
			pw = rs.getString("pw");
			}
			
			if(password.equals(pw)) {
			/*	PrintWriter out = response.getWriter();
				out.println("입력 정보가 맞습니다");*/
				
				HttpSession session = request.getSession();
				session.setAttribute("login_id", id);
				
				
			} else {

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{}
		
		response.sendRedirect(currentUrl);
	}
}
