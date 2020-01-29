package com.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {

	private int userId;

	@Email(message = "Email should be in proper form")
	@NotBlank(message = "Email cannot be blank")
	private String email;

	@Pattern(regexp = "[a-zA-Z]+", message = "Name should contains only alphabetic characters.")
	@NotBlank(message = "Name cannot be blank")
	private String name;

	public User() {
	}

	public User(int userId, @Email String email, @Pattern(regexp = "[a-zA-Z]+") String name) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", name=" + name + "]";
	}

}
