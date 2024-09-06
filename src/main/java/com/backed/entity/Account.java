package com.backed.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "account")
public class Account {
	// -------------------------------------------------------------------
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short Acc_iD;
	// --------------------------------------------------------------------
	@Column(name = "Email", length = 50)
	private String Acc_email;
	// ---------------------------------------------------------------------
	@Column(name = "Username", unique = true, length = 50)
	private String username;
	// --------------------------------------------------------------------
	@Column(name = "FirstName", length = 50)
	private String Acc_fristname;
	// --------------------------------------------------------------------
	@Column(name = "LastName", unique = true, length = 50)
	private String Acc_lastname;
	// --------------------------------------------------------------------
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp // default now()
	private Date Acc_createDate;
	// ---------------------------------------------------------------------
	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Department acc_Department;
	// ---------------------------------------------------------------------

	@ManyToOne
	@JoinColumn(name = "PositionID")
	private Position acc_Position;

	@Column(name = "password", length = 800)
	private String password;

	public Account() {
	}

	public Short getAcc_iD() {
		return Acc_iD;
	}

	public void setAcc_iD(Short acc_iD) {
		Acc_iD = acc_iD;
	}

	public String getAcc_email() {
		return Acc_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account(Short acc_iD, String acc_email, String acc_username, String acc_fristname, String acc_lastname,
			Date acc_createDate, Department acc_Department, Position acc_Position, String password) {
		super();
		Acc_iD = acc_iD;
		Acc_email = acc_email;
		username = acc_username;
		Acc_fristname = acc_fristname;
		Acc_lastname = acc_lastname;
		Acc_createDate = acc_createDate;
		this.acc_Department = acc_Department;
		this.acc_Position = acc_Position;
		this.password = password;
	}

	public void setAcc_email(String acc_email) {
		Acc_email = acc_email;
	}

	public String getAcc_username() {
		return username;
	}

	public void setAcc_username(String acc_username) {
		username = acc_username;
	}

	public String getAcc_fristname() {
		return Acc_fristname;
	}

	public void setAcc_fristname(String acc_fristname) {
		Acc_fristname = acc_fristname;
	}

	public String getAcc_lastname() {
		return Acc_lastname;
	}

	public void setAcc_lastname(String acc_lastname) {
		Acc_lastname = acc_lastname;
	}

	public Date getAcc_createDate() {
		return Acc_createDate;
	}

	public void setAcc_createDate(Date acc_createDate) {
		Acc_createDate = acc_createDate;
	}

	public Department getAcc_Department() {
		return acc_Department;
	}

	public void setAcc_Department(Department acc_Department) {
		this.acc_Department = acc_Department;
	}

	public Position getAcc_Position() {
		return acc_Position;
	}

	public void setAcc_Position(Position acc_Position) {
		this.acc_Position = acc_Position;
	}

	@Override
	public String toString() {
		return "Account [Acc_iD=" + Acc_iD + ", Acc_email=" + Acc_email + ", Acc_username=" + username
				+ ", Acc_fristname=" + Acc_fristname + ", Acc_lastname=" + Acc_lastname + ", Acc_createDate="
				+ Acc_createDate + ", acc_Department=" + acc_Department.getDep_Name() + ", acc_Position="
				+ acc_Position.getPos_ID() + "]";
	}

}
