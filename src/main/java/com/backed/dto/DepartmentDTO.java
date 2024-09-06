package com.backed.dto;

public class DepartmentDTO {
	private String name;
	private Short idShort;

	public Short getIdShort() {
		return idShort;
	}

	public void setIdShort(Short idShort) {
		this.idShort = idShort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDTO(String name) {
		super();
		this.name = name;
	}

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
