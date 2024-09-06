package com.backed.update;

public class DepartmentUpdate {
	private Short iD;
	private String name;

	public Short getiD() {
		return iD;
	}

	public void setiD(Short iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentUpdate(Short iD, String name) {
		super();
		this.iD = iD;
		this.name = name;
	}

	public DepartmentUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
