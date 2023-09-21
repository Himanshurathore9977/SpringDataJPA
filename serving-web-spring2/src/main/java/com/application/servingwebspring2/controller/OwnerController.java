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
import com.application.servingwebspring2.repository.OwnerRepo;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	OwnerRepo ownerRepo  ;  
	
	@GetMapping("/get")
	public List<Owner> getOwner() {
		System.out.println("Hello World ");
		return (List<Owner>)ownerRepo.findAll() ; 
	}
	

	@PostMapping("/post")
	public Owner addOwner(@RequestBody Owner owner) {
		return ownerRepo.save(owner);
	}

}
