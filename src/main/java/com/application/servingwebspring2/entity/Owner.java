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
@Table(name = "owners")
public class Owner {
	@Id                                                                
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@Column(name = "OwnerNo",  nullable = false )
	private int OwnerNo ;
	
	
	private String OwnerName  ; 
	
	@OneToMany(mappedBy = "owner")
	private List<Car>cars ;

	public int getOwnerNo() {
		return OwnerNo;
	}

	public void setOwnerNo(int ownerNo) {
		OwnerNo = ownerNo;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Owner(String ownerName, List<Car> cars) {
		super();
		OwnerName = ownerName;
		this.cars = cars;
	}

	

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Owner [OwnerNo=" + OwnerNo + ", OwnerName=" + OwnerName + ", cars=" + cars + "]";
	} 
	
	
	
}
