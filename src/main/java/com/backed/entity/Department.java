package com.backed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short dep_ID;
	@Column(name = "DepartmentName", nullable = false, unique = true, length = 30)
	private String dep_Name;

	public Department() {
	}

	public Short getDep_ID() {
		return dep_ID;
	}

	public void setDep_ID(Short dep_ID) {
		this.dep_ID = dep_ID;
	}

	public String getDep_Name() {
		return dep_Name;
	}

	public void setDep_Name(String dep_Name) {
		this.dep_Name = dep_Name;
	}

	@Override
	public String toString() {
		return "Department [dep_ID=" + dep_ID + ", dep_Name=" + dep_Name + "]";
	}

}
