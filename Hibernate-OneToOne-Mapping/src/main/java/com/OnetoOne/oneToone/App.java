package com.OnetoOne.oneToone;

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
    	
    	System.out.println("Enter Authot NAME, GENGER, AGE:");
    	
    	Author author = new Author(sc.next(), sc.next(), sc.nextInt());
    	
    	
    	System.out.println("Enter Book NAME, PRICE and NO.OF PAGES:");
    	
    	Book book = new Book(sc.next(), sc.nextInt(), sc.nextInt());
    	
    	author.setBook(book);
    	
    	
    	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    	
    	Session session = sessionfactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	
    	session.persist(author);
    	
    	
    	
    	transaction.commit();
    	
    	sessionfactory.close();
    	
    	session.close();
    	
    	
    }
}
