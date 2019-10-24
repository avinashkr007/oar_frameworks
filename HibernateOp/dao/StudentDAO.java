package edu.jspiders.hibernateop.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.jspiders.hibernateop.dto.StudentDTO;

public class StudentDAO
{
	public void create(StudentDTO student)
	{
		// hibernate logic to insert
		
		Configuration config = new Configuration().configure();
		
		config.addAnnotatedClass(StudentDTO.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.save(student);
		
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		
		session.close();
		
		factory.close();
	}
	
	public StudentDTO selectById(int studentId)
	{
		// hibernate logic to select by id
		
		Configuration config = new Configuration().configure();
		
		config.addAnnotatedClass(StudentDTO.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		StudentDTO student = session.get(StudentDTO.class, studentId);
		
		session.close();
		
		factory.close();
		
		return student;
	}
	
	public int updateById(int studentId)
	{
		// hibernate logic to update records based on id
		
		Configuration config = new Configuration().configure();
		
		config.addAnnotatedClass(StudentDTO.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		StudentDTO student = session.get(StudentDTO.class, studentId);
		
		if(student!= null)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Which Property you want to update ?");
			System.out.println("-----------------------------------");
			System.out.println("1. First name 2. Last name 3. Marks");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the new first name");
				student.setFirstName(sc.next());
			}
			else if(choice == 2)
			{
				System.out.println("Enter the new last name");
				student.setLastName(sc.next());
			}
			else if(choice == 3)
			{
				System.out.println("Enter the new marks");
				student.setMarks(sc.nextDouble());
			}
			
			session.update(student);
			
			session.beginTransaction().commit();
			
		}
		
		session.close();
		
		factory.close();
		
		return 0;
	}
	
	public int deleteById(int studentId)
	{
		// hibernate logic to delete by Id
		

		Configuration config = new Configuration().configure();
		
		config.addAnnotatedClass(StudentDTO.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		StudentDTO student = session.get(StudentDTO.class, studentId);
		
		if(student!= null)
		{
			session.delete(student);
			
			session.beginTransaction().commit();
		}
		else
		{
			System.out.println("Student Record not present");
		}
		
		session.close();
		
		factory.close();
		
		return 0;
	}
}