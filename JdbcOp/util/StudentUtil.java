package edu.jspoar.jdbcop.util;

import java.util.Scanner;

import edu.jspoar.jdbcop.dao.StudentDAO;
import edu.jspoar.jdbcop.dto.Student;

public class StudentUtil 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		
		System.out.println("Welcome to Jdbc Operations");
		System.out.println("--------------------------");
		
		while(true)
		{
			System.out.println("Operations Available are");
			System.out.println("------------------------");
			System.out.println("1. Create");
			System.out.println("2. Read By Id");
			System.out.println("3. Update By Id");
			System.out.println("4. Delete By Id");
			System.out.println("5. Exit the Program");
			System.out.println("-------------------");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the id");
				int id = sc.nextInt();
				
				System.out.println("Enter the first Name");
				String firstName = sc.next();
				
				System.out.println("Enter the last Name");
				String lastName = sc.next();
				
				System.out.println("Enter the marks");
				double marks = sc.nextDouble();
				
				Student student = new Student(id, firstName, lastName, marks);
				
				dao.create(student);
			}
			else if(choice == 2)
			{
				System.out.println("Enter the Id to be fetched");
				int id = sc.nextInt();
				Student student = dao.readById(id);
				
				if(student!= null)
					System.out.println(student);
				else
					System.out.println("Student record is not present");
			}
			else if(choice== 3)
			{
				System.out.println("Enter the Id to be updated");
				int id = sc.nextInt();
				
				int count = dao.updateById(id);
				
				if(count > 0)
					System.out.println("Update Successful");
				else
					System.out.println("No Update Took place");
			}
			else if(choice == 4)
			{
				System.out.println("Enter the Id to be deleted");
				int id = sc.nextInt();
				
				int count = dao.deleteById(id);
				
				if(count > 0)
					System.out.println("Delete Successful");
				else
					System.out.println("No delete Took place");
			}
			else if(choice == 5)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Invalid Choice");
			}
		}
	}
}