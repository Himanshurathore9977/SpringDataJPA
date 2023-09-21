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
import com.application.servingwebspring2.entity.Owner;
import com.application.servingwebspring2.repository.CarRepo;
import com.application.servingwebspring2.repository.OwnerRepo;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	OwnerRepo ownerRepo  ; 
	@Autowired
	CarRepo carRepo  ; 
	
	@GetMapping
	public List<Owner> getAllOwner() {														// GET /users
		System.out.println("Hello World ");
		return (List<Owner>)ownerRepo.findAll() ; 
	}
	@GetMapping("/{ownerNo}")																// GET /users/1
	public Owner getOwner(@PathVariable("ownerNo") Long ownerNo) {
		Optional<Owner> optional  =ownerRepo.findById(ownerNo) ; 
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;		
	}
	

	@PostMapping
	public Owner addOwner(@RequestBody Owner owner) {
		return ownerRepo.save(owner);
	}
	
	@DeleteMapping("/{OwnerNo}")															//DELETE /users/1
	public boolean deleteOwner(@PathVariable Long OwnerNo) {
		System.out.println(OwnerNo);
		ownerRepo.deleteById(OwnerNo) ;
		return true ;
	}
	
	
	@PutMapping("/{OwnerNo}")																//PUT /users/1 			//updation
	public Owner updateOwner(@PathVariable Long OwnerNo, @RequestBody  String ownerName ) {
		Optional<Owner> os =ownerRepo.findById(OwnerNo);
		Owner own = os.get() ; 
		own.setOwnerName(ownerName) ; 
		ownerRepo.save(own) ; 
		return own ;
				
	}
	
	
	@PostMapping("/{OwnerNo}")																//POST /users/1/posts 		//add car 
	public Boolean addCar(@PathVariable Long OwnerNo,@RequestBody Car car){
	    Optional<Owner> optional = ownerRepo.findById(OwnerNo);
	    Owner owner=optional.get();
	    car.setOwner(owner);
	    owner.getCars().add(car) ; 
	    carRepo.save(car) ; 
	    ownerRepo.save(owner) ; 
	    return true;
	}
	
	//GET /users/1/posts
	@GetMapping("/{OwnerNo}/cars")
	public List<Car> getAllCarOfOwner(@PathVariable Long OwnerNo ){
		Optional<Owner> optional = ownerRepo.findById(OwnerNo);
		Owner owner = optional.get() ; 
		return owner.getCars() ; 
	}
	
	
	//GET /users/1/posts/12
	@GetMapping("/{OwnerNo}/cars/{CarNo}")
	public Car getCarByNo(@PathVariable Long OwnerNo , @PathVariable Long CarNo ) {
		Optional<Owner> optionalOwner = ownerRepo.findById(OwnerNo);
		Owner owner = optionalOwner.get() ; 
		 List<Car> Cars = owner.getCars() ; 
		Optional<Car> car = Cars.stream().filter(a -> a.getCarNo() == CarNo ).findFirst() ; 
		return car.get() ; 
		
	}
	
	
}
