package com.example.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
