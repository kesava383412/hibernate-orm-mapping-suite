package com.OnetoMany.OnetoMany;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	Employee employee;
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}


	public Department(int id, String name, Employee employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
	}


	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Department(String name) {
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


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, employee);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(employee, other.employee);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", student=" + employee + "]";
	}
	
	

}
