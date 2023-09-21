package com.application.servingwebspring2.entity; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "cars")
public class Car {
    
@Id                                                                
@GeneratedValue(strategy = GenerationType.SEQUENCE)            
@Column(name = "CarNO" , nullable = false )
private int CarNo ;

private String CarName ;                                           
private String Company ;      

@ManyToOne                                                         
private Owner owner ;

public int getCarNo() {
	return CarNo;
}

public void setCarNo(int carNo) {
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




