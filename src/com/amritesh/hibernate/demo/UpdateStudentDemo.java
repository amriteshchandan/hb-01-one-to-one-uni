package com.amritesh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			student.setFirstName("Nanji Bhai");
			session.getTransaction().commit();
			
			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println(session.createQuery("update Student set email='foo@bar.com'").executeUpdate());
			session.getTransaction().commit();
			
			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			List<Student> studentList = session.createQuery("from Student").getResultList();
			for (Student s : studentList) {
				s.setLastName("Katappa");
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		sessionFactory.close();
	}

}