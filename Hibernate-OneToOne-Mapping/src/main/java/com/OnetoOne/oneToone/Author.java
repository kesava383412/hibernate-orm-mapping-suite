package com.OnetoOne.oneToone;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	String gender;
	
	@Column
	int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_id", referencedColumnName = "id")
	Book book;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int id, String name, String gender, int age, Book book) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.book = book;
	}

	public Author(String name, String gender, int age, Book book) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.book = book;
	}

	public Author(String name, String gender, int age) {
		super();
		
		this.name = name;
		this.gender = gender;
		this.age = age;
		
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, book, gender, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return age == other.age && Objects.equals(book, other.book) && Objects.equals(gender, other.gender)
				&& id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", book=" + book + "]";
	}
	
	
	
	
	
	
}
