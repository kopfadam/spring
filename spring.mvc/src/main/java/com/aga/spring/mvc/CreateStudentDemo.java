package com.aga.spring.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aga.spring.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save java object
			
			//create a student object
			System.out.println("Create a student object");
			Student tempStudent = new Student("Alex", "Johnson", "alex@mail.com");
			
			//start a transaction
			
			//save student object
			
			//commit transaction
		} finally {
			factory.close();
		}

	}

}
