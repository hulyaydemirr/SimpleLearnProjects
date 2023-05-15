package com.simplilearn.servlet;

import com.simplilearn.dao.LoginDao;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (loginDao.checkUserEmail(email)) {
			if (loginDao.checkUserPassword(email, password)) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid password!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid email!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	public void destroy() {
	}
}
