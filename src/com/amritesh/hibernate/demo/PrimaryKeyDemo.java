package com.amritesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.amritesh.hibernate.entity.demo.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student1 = new Student("AB", "CD", "abcd@gmail.com");
			Student student2 = new Student("EF", "GH", "efgh@gmail.com");
			Student student3 = new Student("IJ", "KL", "ijkl@gmail.com");
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		sessionFactory.close();

	}

}