package com.example.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConnection {


	public static void main(String[] args) {
		
		SessionFactory sessionFactory;
		Session session = null;
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		
		session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select count(*) from user");
		
		List list = query.list();
		
		for(int i=0;i<list.size();i++)
		{
			String count = (String)list.get(i).toString();
			System.out.println(count);
		}
	}	

}
