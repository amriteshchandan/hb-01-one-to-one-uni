package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Instructor;
import com.amritesh.hibernate.entity.demo.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = null;
		
		try {
//			Instructor instructor1 = new Instructor("Amritesh", "Chandan", "amritesh.cse@gmail.com");
//			InstructorDetail instructorDetail1 = new InstructorDetail("https://youtube.com/amritesh", "Love 2 Code !!!");
//			instructor1.setInstructorDetail(instructorDetail1);
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			InstructorDetail instructorDetail1 = session.get(InstructorDetail.class, 3);
			Instructor instructor1 = new Instructor("Ankur", "B", "ankur.b@gmail.com");
			instructor1.setInstructorDetail(instructorDetail1);
			session.save(instructor1);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		sessionFactory.close();
	}

}