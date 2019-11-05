package edu.jspiders.hibernateemployeeapp.util;

import java.util.Scanner;

import edu.jspiders.hibernateemployeeapp.dao.EmployeeDAO;
import edu.jspiders.hibernateemployeeapp.dto.Employee;

public class MainApp 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Hibernate Employee App");
		System.out.println("---------------------------------");
		
		EmployeeDAO dao = new EmployeeDAO();
		
		while(true)
		{
			System.out.println("Choices Available");
			System.out.println("-----------------");
			System.out.println("1. Create 2. Read By id 3. Update By Id 4. Delete by Id 5. Exit");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Enter the Choice");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the Emp Id");
				String empId = sc.next();
				
				System.out.println("Enter the First Name");
				String firstName = sc.next();
				
				System.out.println("Enter the Last Name");
				String lastName = sc.next();
				
				System.out.println("Enter the Gender");
				String gender = sc.next();
				
				sc.nextLine();
				
				System.out.println("Enter the designation");
				String designation = sc.nextLine();
				
				System.out.println("Enter the salary");
				double salary = sc.nextDouble();
				
				Employee emp = new Employee(empId, firstName, lastName, gender, designation, salary);
				
				dao.create(emp);
			}
			if(choice == 2)
			{
				System.out.println("Enter the Employee Id you want to READ");
				String empId = sc.next();
			
				Employee emp = dao.readByEmpId(empId);
				
				if(emp!= null)
					System.out.println(emp);
				else
					System.out.println("Employee with the given Id is not present");
				
			}
			if(choice == 3)
			{
				System.out.println("Enter the Employee Id you want to Updated");
				String empId = sc.next();
				
				dao.updateByEmpId(empId);
			}
			if(choice == 4)
			{
				System.out.println("Enter the Employee Id you want to Deleted");
				String empId = sc.next();
				
				dao.deleteByEmpId(empId);
			}
		}
	}
}