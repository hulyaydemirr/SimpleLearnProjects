package com.simplilearn.servlet;

import com.simplilearn.configuration.DatabaseConfiguration;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class AssignStudent
 */
@WebServlet ("/assignStudent")
public class AssignStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignStudent() {
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
		String[] nameList = name.split(" ");
		String classes = request.getParameter("class");

		SessionFactory sf  = DatabaseConfiguration.getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		String hql_classes= "from Classes where class_name='" + classes + "'";
		List<Classes> clas = session.createQuery(hql_classes).list();

		String hql_student = "update Student s set s.classes=:n where s.fname=:fn and s.lname=:ln";

		Query<Student> query = session.createQuery(hql_student);
		query.setParameter("n", clas.get(0));
		query.setParameter("fn", nameList[0]);
		query.setParameter("ln", nameList[1]);

		query.executeUpdate();
		tx.commit();
		session.close();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewStudent.jsp");
		dispatcher.forward(request, response);
	}

}