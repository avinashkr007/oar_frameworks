package edu.jspiders.hibernateop.util;

import java.util.Scanner;

import edu.jspiders.hibernateop.dao.StudentDAO;
import edu.jspiders.hibernateop.dto.StudentDTO;

public class HibernateUtil 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Hibernate Operations");
		System.out.println("-------------------------------");
		
		StudentDAO dao = new StudentDAO();
		
		while(true)
		{
			System.out.println("Choices available are");
			System.out.println("---------------------");
			System.out.println("1. Create 2. Read By Id "
					+ "3. Update by Id 4. Delete By id 5. Exit");
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter the Choice");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter student Id");
				int studentId = sc.nextInt();
				
				System.out.println("Enter student first Name");
				String firstName = sc.next();
				
				System.out.println("Enter student last Name");
				String lastName = sc.next();
				
				System.out.println("Enter student marks");
				double marks = sc.nextDouble();
				
				StudentDTO student = new StudentDTO(studentId, firstName, lastName, marks);
				
				dao.create(student);
			}
			
			else if(choice == 2)
			{
				System.out.println("Enter student Id to be searched");
				int studentId = sc.nextInt();
				
				StudentDTO student = dao.selectById(studentId);
			
				System.out.println("Student info --> "+student);
			}
			else if(choice == 3)
			{
				System.out.println("Enter student Id to be updated");
				int studentId = sc.nextInt();
				
				dao.updateById(studentId);
			}
			else if(choice == 4)
			{
				System.out.println("Enter student Id to be deleted");
				int studentId = sc.nextInt();
				
				dao.deleteById(studentId);
			}
		}
	}
}