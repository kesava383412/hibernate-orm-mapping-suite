package com.ManytoMany.ManytoMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column
	String name;

	
	// mappedBy should match the field name in Person class
	// In Person class field name is: clubs
	@ManyToMany(mappedBy = "courses")
	List<Student> students;

	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	
	
	// Constructor with all fields
	public Course(int id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	
	
	// Constructor without id
	public Course(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	
	
	// Constructor only with club name
	public Course(String name) {
		super();
		this.name = name;
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

	
	
	// Getter should return List<Person>
	public List<Student> getStudents() {
		return students;
	}

	
	
	// Setter should accept List<Person>
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, students);
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Course other = (Course) obj;

		return id == other.id &&
				Objects.equals(name, other.name) &&
				Objects.equals(students, other.students);
	}

	
	
	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}