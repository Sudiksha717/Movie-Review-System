package com.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "movie_users")
public class User 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
    @Column(name="movie_users_id")
    private int userId;
	
  @Column(name="movie_users_name")
  private String userName;
  
  @Column(name="movie_users_mail")
  private String userMail;
  
  @Column(name="movie_users_password")
  private String userPass;
  
  @OneToMany(mappedBy = "user")
  private List<Review> reviews;
	
  public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
public User() 
{
	// TODO Auto-generated constructor stub
}

public User(int userId, String userName, String userMail, String userPass) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userMail = userMail;
	this.userPass = userPass;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserMail() {
	return userMail;
}

public void setUserMail(String userMail) {
	this.userMail = userMail;
}

public String getUserPass() {
	return userPass;
}

public void setUserPass(String userPass) {
	this.userPass = userPass;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + ", userPass=" + userPass
			+ "]";
}


}
