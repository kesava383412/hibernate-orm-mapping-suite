package com.OnetoMany.OnetoMany;

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

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);



        // Creating Course objects
        // These are normal Java objects now
        Department department1 = new Department("Java");
        Department department2 = new Department("SQL");
        Department department3 = new Department("DSA");



        // Asking user details
        System.out.println("Enter Student NAME, EMAIL and PHONE:");

        // Creating Student object using user input
        Employee employee =
                new Employee(sc.nextLine(), sc.next(), sc.next());



        // IMPORTANT PART
        // Setting student object into every course object

        // Since Course class contains @ManyToOne
        // this side is OWNER side
        // Hibernate mainly checks this side to store foreign key

        department1.setEmployee(employee);
        department2.setEmployee(employee);
        department3.setEmployee(employee);



        // Creating List to store all course objects
        List<Department> courselist = new ArrayList<Department>();



        // Adding courses into list
        courselist.add(department1);
        courselist.add(department2);
        courselist.add(department3);



        // Setting complete course list to student

        // This updates student object's course list
        // This is inverse side (@OneToMany side)

        // This alone is NOT enough for database relationship
        // But it keeps Java objects synchronized

        employee.setCourse(courselist);




        // Creating SessionFactory object
        // Reads hibernate.cfg.xml file
        SessionFactory sessionfactory =
                new Configuration().configure().buildSessionFactory();




        // Opening Hibernate Session
        Session session = sessionfactory.openSession();




        // Starting transaction
        Transaction transaction = session.beginTransaction();




        // Saving student object

        // Because of CascadeType.ALL
        // Hibernate also saves all Course objects automatically

        session.persist(employee);




        // Permanently saving changes into database
        transaction.commit();




        // Closing SessionFactory
        sessionfactory.close();



        // Closing session
        session.close();

    }
}