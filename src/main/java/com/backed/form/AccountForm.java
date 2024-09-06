package com.backed.form;

public class AccountForm {
	private String email;
	private String username;
	private Short department;
	private Short position;
	private String first;

	public Short getPosition() {
		return position;
	}

	public void setPosition(Short position) {
		this.position = position;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getDepartment() {
		return department;
	}

	public void setDepartment(Short department) {
		this.department = department;
	}

}
