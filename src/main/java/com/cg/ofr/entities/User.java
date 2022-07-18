package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column
	@NotEmpty(message="username should not be empty")
	private String userName;
	
	@Column
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "must not contain special characters")
	private String password;
	
	@Column
	@NotEmpty(message="userType should not be empty")
	private String userType;
	
	
	public User() {}


	public User(  String userName, String password, String userType) {
		super();
	
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}


	public Integer getUserId() {
		return userId;
	}


	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}
		
}
