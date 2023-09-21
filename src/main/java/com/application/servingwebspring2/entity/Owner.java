package com.application.servingwebspring2.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
	@Id                                                                
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@Column(name = "OwnerNo",  nullable = false )
	private Long OwnerNo ;
	
	
	private String OwnerName  ; 
	
	@OneToMany(mappedBy = "owner")
	private List<Car>car ;

	public Long getOwnerNo() {
		return OwnerNo;
	}

	public void setOwnerNo(Long ownerNo) {
		OwnerNo = ownerNo;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public List<Car> getCars() {
		return car;
	}

	public void setCars(List<Car> car) {
		this.car = car;
	}

	public Owner(String ownerName, List<Car> car) {
		OwnerName = ownerName;
		this.car = car;
	}

	

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Owner [OwnerNo=" + OwnerNo + ", OwnerName=" + OwnerName + ", car=" + car + "]";
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	
	public void setCar(List<Car> car) {
		this.car = car;
	}

	
	
	
	
}
