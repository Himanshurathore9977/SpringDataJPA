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

import com.application.servingwebspring2.entity.Owner;
import com.application.servingwebspring2.repository.OwnerRepo;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	OwnerRepo ownerRepo  ;  
	
	@GetMapping("/")
	public List<Owner> getOwner() {
		System.out.println("Hello World ");
		return (List<Owner>)ownerRepo.findAll() ; 
	}
	

	@PostMapping("/post")
	public Owner addOwner(@RequestBody Owner owner) {
		return ownerRepo.save(owner);
	}
	
	@DeleteMapping("/{OwnerNo}")
	public boolean deleteOwner(@PathVariable Long OwnerNo) {
		System.out.println(OwnerNo);
		ownerRepo.deleteById(OwnerNo) ; 
		return true ;
	}
	
	
	@PutMapping("/{OwnerNo}")
	public Owner updateOwner(@PathVariable Long OwnerNo, @RequestBody  String ownerName ) {
		
		Optional<Owner> os =ownerRepo.findById(OwnerNo);
		Owner own = os.get() ; 
		own.setOwnerName(ownerName) ; 
		ownerRepo.save(own) ; 
		return own ;
		
	}
}
