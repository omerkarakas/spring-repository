package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Department;
import com.omer.entity.Jobs;

public class HibernateDepartment {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Department.class)
			.addAnnotatedClass(Jobs.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		Department dep = new Department("Ömer3",100,1700);

		session.beginTransaction();
		
		session.save(dep);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
