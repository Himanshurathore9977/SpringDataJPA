package com.application.servingwebspring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.servingwebspring2.entity.Car;
import com.application.servingwebspring2.entity.Owner;
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
	
	@PostMapping("/post")
	public Car addOwner(@RequestBody Car car) {
		return carRepo.save(car);
	}
}
