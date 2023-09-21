package com.application.servingwebspring2.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.servingwebspring2.entity.Owner;

public interface OwnerRepo  extends CrudRepository<Owner, Long>   {

}
