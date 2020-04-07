package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Jobs;

public class HibernateTest {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Jobs.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		Jobs jobs = new Jobs("TEST","TEST MÜH",3000,5000);

		session.beginTransaction();
		
		session.save(jobs);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
