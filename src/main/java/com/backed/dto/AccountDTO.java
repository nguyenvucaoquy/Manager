package com.backed.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountDTO {
	private String email;
	private String username;
	private String acc_Department;
	private Short id;
	private String emailString;
	private String fullname;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date creatDate;
	private String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getAcc_Department() {
		return acc_Department;
	}

	public void setAcc_Department(String acc_Department) {
		this.acc_Department = acc_Department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
