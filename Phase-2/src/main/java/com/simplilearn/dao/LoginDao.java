package com.simplilearn.dao;


import com.simplilearn.configuration.DatabaseConfiguration;
import com.simplilearn.entity.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDao {

	private SessionFactory sessionFactory;

	public LoginDao() {
		sessionFactory = DatabaseConfiguration.getSessionFactory();
	}

	public boolean checkUserEmail(String email){
		Session session =  sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String sql = "SELECT * FROM Login WHERE email = :email";
		Query query = session.createSQLQuery(sql);
		query.setParameter("email", email);

		List<Login> logins = query.getResultList();

		if(logins.isEmpty()){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean checkUserPassword(String email, String password){
		Session session =  sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String sql = "SELECT * FROM Login WHERE email = :email";
		Query query = session.createNativeQuery(sql, Login.class);
		query.setParameter("email", email);

		List<Login> logins = query.getResultList();

		if(logins.get(0).getPassword().equals(password)){
			return true;
		}
		transaction.commit();
		session.close();
		return false;
	}
}
