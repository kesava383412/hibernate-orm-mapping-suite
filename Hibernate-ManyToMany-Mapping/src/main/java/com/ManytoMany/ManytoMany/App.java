package com.ManytoMany.ManytoMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
    	
    	
    	 System.out.println("Enter  Student's Details:");
    	 
    	 System.out.println("Enter 1st Student Name: ");
    	 String name1 = sc.next();
    	 
    	 System.out.println("Enter Student Phone Number: ");
    	 String phone1 = sc.next();
    	 
    	 Student student1 = new Student(name1, phone1);
    	 
    	 
    	 
    	 System.out.println("Enter 2nd Student Name: ");
    	 String name2 = sc.next();
    	 
    	 System.out.println("Enter 2nd Student Phone Number: ");
    	 String phone2 = sc.next();
    	 
    	 Student student2 = new Student(name2, phone2);
    	 
    	 
    	 
    	 
    	 System.out.println("Enter 3rd Student Name: ");
    	 String name3 = sc.next();
    	 
    	 System.out.println("Enter 3rd Student Phone Number: ");
    	 String phone3 = sc.next();
    	 
    	 Student student3 = new Student(name3, phone3);
    	 
    	 
    	 
    	 
    	 List<Student> student = new ArrayList<Student>();
    	 student.add(student1);
    	 student.add(student2);
    	 student.add(student3);
    	 
    	 
    	 
    	 
    	 
    	 Course c1 = new Course("JAVA");
    	 Course c2 = new Course("SQL");
    	 Course c3 = new Course("DSA");
    	 
    	 
    	 
    	 List<Course> course1 = new ArrayList<Course>();
    	 course1.add(c1);
    	 course1.add(c2);
    	 
    	 
    	 List<Course> course2 = new ArrayList<Course>();
    	 course2.add(c2);
    	 course2.add(c3);
    	 
    
    	 List<Course> course3 = new ArrayList<Course>();
    	 course3.add(c3);
    	 course3.add(c1);
    	 
    	 
    	 student1.setCourses(course1);
    	 student2.setCourses(course2);
    	 student3.setCourses(course3);
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    	 
    	 
    	 Session session = sessionfactory.openSession();
    	 
    	 
    	 Transaction transaction = session.beginTransaction();
    	 
    	 
    	 session.persist(student1);
    	 session.persist(student2);
    	 session.persist(student3);
    	 
    	 
    	 transaction.commit();
    	 
    	 
    	 session.close();
    	 
    	 
    	 sessionfactory.close();
    	 
    	 
    	 
    	 
    }
}
