package edu.jspoar.jdbcop.dto;

import java.io.Serializable;

public class Student implements Serializable
{
	private int id;
	private String firstName;
	private String lastName;
	private double marks;
	
	public Student() 
	{
		System.out.println("Student Object Created");
	}

	public Student(int id, String firstName, String lastName, double marks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks + "]";
	}
}
