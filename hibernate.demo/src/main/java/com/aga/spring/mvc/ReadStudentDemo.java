package com.aga.spring.mvc;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aga.spring.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create a student object
			System.out.println("Create a student object");
			Student tempStudent = new Student();

			// start a transaction
			session.beginTransaction();

			// retrieve student object with id
			// and assign result object to tempStudent
			/*
			 * System.out.println("Get the student from database"); tempStudent =
			 * session.get(Student.class, 1); System.out.println(tempStudent);
			 */

			// retrieve all the students with query
			List<Student> students = new LinkedList<Student>();
			// students = session.createQuery("from Student").getResultList();

			// display all the students
			// displayStudents(students);

			// retrieve students whose last name is "Laptop"
			students = session.createQuery("from Student s where s.lastName='Laptop'").getResultList();

			// display all the students with lastname Laptop
			displayStudents(students);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
