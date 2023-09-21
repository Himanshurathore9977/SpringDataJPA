package com.application.servingwebspring2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.application.servingwebspring2.entity.Car;

public interface CarRepo extends  CrudRepository<Car, Long>  {

}
