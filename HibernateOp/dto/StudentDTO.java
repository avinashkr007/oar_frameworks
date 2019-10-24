package edu.jspiders.hibernateop.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_info")
public class StudentDTO
{
	@Id
	@Column(name="id")
	private int studentId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="marks")
	private double marks;
	
	public StudentDTO() 
	{
		System.out.println(this.getClass().getSimpleName()+"Object Created");
	}

	public StudentDTO(int studentId, String firstName, String lastName, double marks)
	{
		System.out.println(this.getClass().getSimpleName()+"Object Created using arg-constructor");
		
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "StudentDTO [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", marks="
				+ marks + "]";
	}
}