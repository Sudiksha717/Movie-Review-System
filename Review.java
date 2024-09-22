package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name = "reviews")
public class Review 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	 @Column(name="review_id")
	 private int reviewId;
	
	 @Column(name="review_content")
	 private int reviewContent;
	 
	 @ManyToOne
	 @JoinColumn(name = "movie_users_id")
	 private Movie movie;
	 
	 @ManyToOne
	 @JoinColumn(name = "movie_id")
	 private User user;
	 
	 public Review(int reviewId, int reviewContent, Movie movie, User user) {
		super();
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.movie = movie;
		this.user = user;
	}



	public Review() 
	 {
		// TODO Auto-generated constructor stub
	}

	

	public Review(int reviewId, int reviewContent, User user) {
		super();
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.user = user;
	}



	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(int reviewContent) {
		this.reviewContent = reviewContent;
	}


	public Movie getMovie() {
		return movie;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewContent=" + reviewContent + ", movie=" + movie + ", user="
				+ user + "]";
	}
	
	 
}
