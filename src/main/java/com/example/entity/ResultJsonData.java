package com.example.entity;

import java.io.Serializable;
import java.util.List;

public class ResultJsonData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String address;

	private Department depId;

	private List<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

}
