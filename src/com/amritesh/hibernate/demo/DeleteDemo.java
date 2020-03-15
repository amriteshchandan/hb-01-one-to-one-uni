package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 3);
			// Will delete associated objects to due to CascaseType.ALL
			if (instructor != null) 
				session.delete(instructor);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		sessionFactory.close();
	}

}