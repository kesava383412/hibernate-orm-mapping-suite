package com.OnetoMany.OnetoMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	String email;
	
	@Column
	String phone;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	List<Department> departments;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String name, String email, String phone, List<Department> departments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.departments = departments;
	}


	public Employee(String name, String email, String phone, List<Department> departments) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.departments = departments;
	}


	public Employee(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Department> getCourse() {
		return departments;
	}


	public void setCourse(List<Department> departments) {
		this.departments = departments;
	}


	@Override
	public int hashCode() {
		return Objects.hash(departments, email, id, name, phone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(departments, other.departments) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}


	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", departments=" + departments
				+ "]";
	}
	
	

}
