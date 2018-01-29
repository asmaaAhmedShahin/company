package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table( name = "employee")
public class Employee  implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id",nullable=false)
	private Integer id ;

	@NotBlank
   	@Column(name="name", nullable=false)
	private String name;


	//@Size(min = 1, max = 8)
 	@Column(name="mobile", nullable=false)
	private int mobile;
	
	@Column(name="address",nullable=false)
	private String address;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dep_Id", nullable=false)
	private Department depId;

		
	


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


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	
}
