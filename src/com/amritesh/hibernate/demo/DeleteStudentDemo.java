package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 1);
			session.delete(student);
			session.getTransaction().commit();
			session.close();
			
			
			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println(session.createQuery("delete Student s where s.id = 2").executeUpdate());
			session.getTransaction().commit();
			session.close();
			
			
		} catch (Exception e) {
			System.out.println("Exception Here");
			e.printStackTrace();
		}
		sessionFactory.close();
	}

}