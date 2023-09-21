package com.application.servingwebspring2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.servingwebspring2.entity.Car;
import com.application.servingwebspring2.repository.CarRepo;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarRepo carRepo ;  
	
	@GetMapping("/")
	public List<Car> getAllCar() {
		System.out.println("Hello World ");
		return (List<Car>)carRepo.findAll() ; 
	}
	
	@PostMapping("/addCar")
	public Car adCar(@RequestBody Car car) {
		System.out.println(car);
		return carRepo.save(car);
	}
	
	@DeleteMapping("/{CarNo}")
	public boolean deleteCar(@PathVariable Long CarNo) {
		System.out.println(CarNo);
		carRepo.deleteById(CarNo) ; 
		return true ;
		
	}

}
