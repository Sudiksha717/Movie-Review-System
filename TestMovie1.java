package com.runner;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Review;

public class TestMovie1 {

	public static void main(String[] args) 
	{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//-----Insert User-----
		
//		User user1 = new User(0,"abc","abc@gmail.com","abcpass");
//		User user2 = new User(0,"xyz","xyz@gmail.com","xyzpass");
//
//		session.save(user1);
//		session.save(user2);
		
		//-----Insert Review-----
		
//		User user = new  User();
//		user.setUserId(15);
//		
//		Movie movie = new Movie();
//		movie.setMovieId(13);
//		
//		Review review = new Review(0,10,movie,user);
//		session.save(review);
		
		
		//-----Fetch the reviews-----
		Query query= session.createQuery("from reviews");
		List<Review> reviews= query.list();
		
		for(Review review: reviews)
		{
			System.out.println(reviews);
			System.out.println(review.getUser()); // if we dont add user and movie in a tostring of review then we will this two lines to print users and movies. otherwise only print reviews.
			System.out.println(review.getMovie());
		}
		transaction.commit();
		session.close();
	}

}
