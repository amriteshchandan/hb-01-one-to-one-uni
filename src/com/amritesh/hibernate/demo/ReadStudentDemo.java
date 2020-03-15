package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student1 = new Student("Amritesh", "Chandan", "amritesh.cse@gmail.com");
			session.beginTransaction();
			session.save(student1);
			session.getTransaction().commit();
			System.out.println("Generated Value :: " + student1.getId());
			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting Student With ID :: " + student1.getId());
			Student student2 = session.get(Student.class, student1.getId());
			System.out.println("GET Complete :: " + student2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		sessionFactory.close();
	}

}