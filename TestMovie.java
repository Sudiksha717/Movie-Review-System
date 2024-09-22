package com.runner;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Movie;

public class TestMovie {

	public static void main(String[] args) 
	{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		
		Scanner sc = new Scanner(System.in);
		int choice;
		 
		do
		{
			Processes();
			System.out.println("enter your choice");
			  choice = sc.nextInt();
			System.out.println("The choice is: "+choice);
			Transaction transaction = session.beginTransaction();
	        switch(choice)
	        {
	          
	        case 1:
	        {
	        	System.out.println("enter the movie name: ");
	        	String m_name = sc.next();
	        	System.out.println("enter the movie length: ");
	        	int m_length = sc.nextInt();
	        	System.out.println("enter the movie language: ");
	        	String m_language = sc.next();
	        	System.out.println("enter the movie genre: ");
	        	String m_genre = sc.next();
	        	Movie movie1 = new Movie(0,m_name,m_length,m_language,m_genre);
	    	
	    		session.save(movie1);
	    		
	    		 transaction.commit();
	 			
	        }
	        break;
	        case 2:
	        {
	        	
	        	Movie movie = new Movie(6,"Bigil",130,"Tamil","Action"); // here id i.e. primary key of the table must be given.
	        	session.update(movie);
	        	System.out.println("Movie is updated successfully.");
	        	transaction.commit();
	        }
	        break;
	        case 3:
	        {
	        	System.out.println("enter movie id :");
	        	int id = sc.nextInt();
	        	Movie movie1 = new Movie();
	        	movie1.setMovieId(id);
	        	session.delete(movie1);
	        	System.out.println("Movie is deleted successfully.");
	        	transaction.commit();
	        }
	        break;
	        case 4:
	        {
	        	Query query = session.createQuery("from movies");  // If we use entity then we will use entity name or from class i.e. Movie is a class name not the table name
	        	List<Movie> movies = query.list();
	        	
	        	for(Movie movie:movies)
	        	{
	        		System.out.println(movie);
	        	}
	        	transaction.commit();
	        }
	        break;
	        }
			
		}
		while(choice!=0);
		session.close();
		}

	private static void Processes() 
	{
		System.out.println("\n Movie Review System");
		System.out.println("1. Insert movie");
		System.out.println("2. Update movie");
		System.out.println("3. Delete movie");
		System.out.println("4. display movie");
	}
	 
}
//-----Insert Movie-----
//Movie movie1 = new Movie(0,"Mahabharat",160,"Sanskrit","Mythology");
//Movie movie2 = new Movie(0,"Ramayana",150,"Hindi","Life");
//Movie movie3 = new Movie(0,"Bigil",180,"Tamil","Action");
//
//session.save(movie1);
//session.save(movie2);
//session.save(movie3);


// -----Update Movie-----

//Movie movie = new Movie(3,"Bigil",130,"Tamil","Action"); // here id i.e. primary key of the table must be given.
//session.update(movie);
//System.out.println("Movie is updated successfully.");

// -----Delete Movie-----


//1.first way to delete movie

//Movie movie = new Movie(3,"null",0,"null","null");
//session.delete(movie);
//System.out.println("Movie is deleted successfully.");

//2. second way to delete movie

//Movie movie = new Movie();
//movie.setMovieId(1);
//session.delete(movie);
//System.out.println("Movie is deleted successfully.");


// -----Fetch All-----
//Query query = session.createQuery("from movies");  // If we use entity then we will use entity name or from class i.e. Movie is a class name not the table name
//List<Movie> movies = query.list();
//
//for(Movie movie:movies)
//{
//	System.out.println(movie);
//}
