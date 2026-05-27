package com.OnetoOne.oneToone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	int price;
	
	@Column
	int noofpages;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	
		
	public Book(int id, String name, int price, int noofpages) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.noofpages = noofpages;
	}

	


	public Book(String name, int price, int noofpages) {
		super();
		this.name = name;
		this.price = price;
		this.noofpages = noofpages;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNoofpages() {
		return noofpages;
	}

	public void setNoofpages(int noofpages) {
		this.noofpages = noofpages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, noofpages, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id && Objects.equals(name, other.name) && noofpages == other.noofpages
				&& price == other.price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", noofpages=" + noofpages + "]";
	}
	
	
	
	
	

	
	
}
