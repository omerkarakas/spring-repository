package com.omer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@Column(name="department_id")
	@SequenceGenerator(name="dept_seq",sequenceName="DEPARTMENTS_SEQ", allocationSize = 10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dept_seq")
	private int id;
	
	@Column(name="department_name")
	private String name;
	
	@Column(name="manager_id")
	private int managerId;
	
	@Column(name="location_id")
	private int locationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public Department(String name, int managerId, int locationId) {
		super();
		this.name = name;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	
	
	
}
