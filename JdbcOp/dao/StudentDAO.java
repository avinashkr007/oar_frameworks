package edu.jspoar.jdbcop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import edu.jspoar.jdbcop.dto.Student;

public class StudentDAO 
{
	public void create(Student student)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			// load and Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
		
			// Establish a Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frameworks_db?user=nithesh&password=1234");
		
			// create a platform/jdbc statement
			String query = "insert into student_info values(?,?,?,?)";
		
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getFirstName());
			pstmt.setString(3, student.getLastName());
			pstmt.setDouble(4, student.getMarks());
			
			//execute the query
			int count = pstmt.executeUpdate();
		
			if(count > 0)
				System.out.println("Student Info inserted Successfully");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			
			System.out.println("Student Info not inserted");
		}
		finally
		{
			if(pstmt!= null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(con!= null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public Student readById(int id)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			// load and Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
		
			// Establish a Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frameworks_db?user=nithesh&password=1234");
			
			// create a platform/jdbc statement
			String query = "select * from student_info where id = ?";
		
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			//execute the query
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Student student = new Student();
				
				student.setId(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setMarks(rs.getDouble(4));
				
				return student;
			}
		
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(rs!= null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(pstmt!= null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(con!= null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	public int updateById(int id)
	{
		Student student = readById(id);
		
		if(student!= null)
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try
			{
				
				// load and Register the Driver
				Class.forName("com.mysql.jdbc.Driver");
			
				// Establish a Connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frameworks_db?user=nithesh&password=1234");
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Choices Are");
				System.out.println("-----------");
				System.out.println("1. First Name 2. Last Name 3. Marks");
				System.out.println("-----------------------------------");
				System.out.println("Enter Your Choice");
				int choice = sc.nextInt();
				
				if(choice == 1)
				{
					System.out.println("Enter the New First Name");
					String firstName = sc.next();
					
					String query = "update student_info set first_name = ? where id = ?";
					
					pstmt = con.prepareStatement(query);
					
					pstmt.setString(1, firstName);
					pstmt.setInt(2, id);
					
					return pstmt.executeUpdate();
				}
				else if(choice == 2)
				{
					System.out.println("Enter the New Last Name");
					String lastName = sc.next();
					
					String query = "update student_info set last_name = ? where id = ?";
					
					pstmt = con.prepareStatement(query);
					
					pstmt.setString(1, lastName);
					pstmt.setInt(2, id);
					
					return pstmt.executeUpdate();
				}
				else if(choice == 3)
				{
					System.out.println("Enter the New marks");
					double marks = sc.nextDouble();
					
					String query = "update student_info set marks = ? where id = ?";
					
					pstmt = con.prepareStatement(query);
					
					pstmt.setDouble(1, marks);
					pstmt.setInt(2, id);
					
					return pstmt.executeUpdate();
				}
				else
				{
					System.out.println("Invalid Choice");
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(pstmt!= null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if(con!= null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		else
			System.out.println("Student Record Not present for Updation");
		
		// jdbc logic to update the record based on ID
		return 0;
	}
	
	public int deleteById(int id)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			// load and Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
		
			// Establish a Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frameworks_db?user=nithesh&password=1234");
		
			// create a platform/jdbc statement
			String query = "delete from student_info where id=?";
		
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			//execute the query
			int count = pstmt.executeUpdate();
			
			return count;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			
			System.out.println("Student Info not inserted");
		}
		finally
		{
			if(pstmt!= null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(con!= null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return 0;
	}
}
