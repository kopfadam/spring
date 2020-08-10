package com.aga.spring.mvc;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aga.spring.entity.Student;

public class UpdateDeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int id= 3;
			
			//start a transaction
			session.beginTransaction();
				
			//get student with id=3
			Student student = session.get(Student.class, id);
			//update the name
			//student.setFirstName("Caner");
			
			//bulk update
			//session.createQuery("update Student set email='naber@mail.com'").executeUpdate();
			
			//delete a student with id
			session.delete(student);
			//session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}
	
	public void deleteStudent(int id) {
		
	}

}
