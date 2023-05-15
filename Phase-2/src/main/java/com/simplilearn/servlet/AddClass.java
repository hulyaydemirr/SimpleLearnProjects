package com.simplilearn.servlet;

import com.simplilearn.configuration.DatabaseConfiguration;
import com.simplilearn.entity.Classes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/addClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("class");

		SessionFactory sf = DatabaseConfiguration.getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Classes classes = new Classes();
		classes.setClass_name(name);

		session.save(classes);

		tx.commit();
		session.close();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewClass.jsp");
		dispatcher.forward(request, response);
	}
}
