package com.simplilearn.servlet;

import com.simplilearn.configuration.DatabaseConfiguration;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;
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
 * Servlet implementation class AssignTeacher
 */
@WebServlet ("/assignTeacher")
public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTeacher() {
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
		String[] nameArray = name.split(" ");
		String subject = request.getParameter("subject");

		SessionFactory sf  = DatabaseConfiguration.getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		String hql_teacher= "from Teacher where first_name='" + nameArray[0] + "'" + " and last_name='" + nameArray[1] + "'";
		List<Teacher> teachers = session.createQuery(hql_teacher).list();

		String hql_subject = "update Subject s set s.teacher=:n where s.subject_name=:sn";

		Query<Subject> query = session.createQuery(hql_subject);
		query.setParameter("n", teachers.get(0));
		query.setParameter("sn", subject);
		query.executeUpdate();

		tx.commit();
		session.close();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewTeachers.jsp");
		dispatcher.forward(request, response);
	}

}