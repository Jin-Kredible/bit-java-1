package com.bit.project1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Logout")
public class LogOutServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String currentUrl =request.getParameter("current_url");
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(currentUrl);
	}
}
