package edu.jspiders.hibernateemployeeapp.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.jspiders.hibernateemployeeapp.dto.Employee;

public class EmployeeDAO 
{
	public void create(Employee employee)
	{
		// hibernate logic to store
		
		//Configuration config = ;
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.save(employee);
		
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		
		session.close();
	}
	
	public Employee readByEmpId(String empId)
	{
		// hibernate logic to read
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee = session.get(Employee.class, empId);
		
		session.close();
		
		return employee;
	}
	
	public void updateByEmpId(String empId)
	{
		// hibernate logic to update one record
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee = session.get(Employee.class, empId);
		
		if(employee!= null)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Choices For Updation are");
			System.out.println("------------------------");
			System.out.println("1. First Name 2. Last Name 3. Designation 4. Salary");
			System.out.println("---------------------------------------------------");
			System.out.println("Enter the Choice");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the New First Name");
				String firstName = sc.next();
				employee.setFirstName(firstName);
			}
			else if(choice == 2)
			{
				System.out.println("Enter the New Last Name");
				String lastName = sc.next();
				employee.setLastName(lastName);
			}
			else if(choice == 3)
			{
				sc.nextLine();
				
				System.out.println("Enter the New Designation");
				String designation = sc.nextLine();
				employee.setDesignation(designation);
			}
			else if(choice == 4)
			{
				System.out.println("Enter the New Salary");
				double salary = sc.nextDouble();
				employee.setSalary(salary);
			}
			else
				System.out.println("Enter the right Choices");
			
			session.saveOrUpdate(employee);
			
			session.beginTransaction().commit();
		}
		else
			System.out.println("Employee with the Given Id is not Present for Updation");
		
		session.close();
	}
	
	public void deleteByEmpId(String empId)
	{
		// hibernate logic to delete one record
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee = session.get(Employee.class, empId);
		
		if(employee!= null)
		{
			session.delete(employee);
			session.beginTransaction().commit();
		}
		else
			System.out.println("Employee with the Given Id is not Present for Deletion");
		
		session.close();
		
	}
}
