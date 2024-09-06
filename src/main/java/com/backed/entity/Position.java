package com.backed.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short Pos_ID;

	@Column(name = "PositionName", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private PositionName pos_Name;

	@OneToMany(mappedBy = "acc_Position")
	List<Account> accounts;

	public enum PositionName {
		Dev, Test, ScrumMaster, PM
	}

	public Position() {
	}

	public Short getPos_ID() {
		return Pos_ID;
	}

	public void setPos_ID(Short pos_ID) {
		Pos_ID = pos_ID;
	}

	public PositionName getPos_Name() {
		return pos_Name;
	}

	public void setPos_Name(PositionName pos_Name) {
		this.pos_Name = pos_Name;
	}

}
