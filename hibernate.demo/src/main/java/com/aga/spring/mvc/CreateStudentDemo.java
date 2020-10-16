package com.aga.spring.mvc;

import java.util.Date;

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
			String theDateOfBirthStr = "11/12/2005";
			 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
            Student tempStudent = new Student("Haci", "Nettin", "gokhanyinebilemedi@mail.com", theDateOfBirth);
 
			
			//start a transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("Save the student");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}catch (Exception exc) {
            exc.printStackTrace();
        } finally {
			factory.close();
		}

	}

}
