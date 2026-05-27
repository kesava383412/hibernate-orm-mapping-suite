package com.ManytoMany.ManytoMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column
	String name;

	@Column
	String phone;

	
	
	// Many persons can join many clubs
	// CascadeType.ALL automatically saves Club objects
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "student_course",
		joinColumns = @JoinColumn(name = "student_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	List<Course> courses;

	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Student(int id, String name, String phone, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.courses = courses;
	}

	
	
	public Student(String name, String phone, List<Course> courses) {
		super();
		this.name = name;
		this.phone = phone;
		this.courses = courses;
	}

	
	
	public Student(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	
	
	public int getId() {
		return id;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getPhone() {
		return phone;
	}

	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	public List<Course> getCourses() {
		return courses;
	}

	
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(courses, id, name, phone);
	}

	
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Student other = (Student) obj;

		return Objects.equals(courses, other.courses)
				&& id == other.id
				&& Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

	
	
	// Avoid printing clubs to prevent recursive loop
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}