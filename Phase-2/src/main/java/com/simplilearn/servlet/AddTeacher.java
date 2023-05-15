package com.simplilearn.servlet;

import com.simplilearn.configuration.DatabaseConfiguration;
import com.simplilearn.entity.Teacher;
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

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet ("/addTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacher() {
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

		String name = request.getParameter("name");
		String lname = request.getParameter("lname");

		SessionFactory sf  = DatabaseConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Teacher teacher = new Teacher();
		teacher.setFirst_name(name);
		teacher.setLast_name(lname);

		session.save(teacher);
		tx.commit();
		session.close();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewTeachers.jsp");
		dispatcher.forward(request, response);
	}

}
