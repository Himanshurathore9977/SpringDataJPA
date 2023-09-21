package com.application.servingwebspring2.entity; 

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "car")
public class Car {
    
@Id                                                                
@GeneratedValue(strategy = GenerationType.SEQUENCE)            
@Column(name = "CarNO" , nullable = false )
private Long CarNo ;

private String CarName ;                                           
private String Company ;      

@JsonIgnore
@ManyToOne                                                         
private Owner owner ;

public Long getCarNo() {
	return CarNo;
}

public void setCarNo(Long carNo) {
	CarNo = carNo;
}

public String getCarName() {
	return CarName;
}

public void setCarName(String carName) {
	CarName = carName;
}

public String getCompany() {
	return Company;
}

public void setCompany(String company) {
	Company = company;
}

public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}

public Car(String carName, String company, Owner owner) {
	super();
	CarName = carName;
	Company = company;
	this.owner = owner;
}

public Car() {

}



}




