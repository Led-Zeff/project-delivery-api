package com.project.delivery.project.delivery.api.repository;

import com.project.delivery.project.delivery.api.model.Shopping;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingRepository extends MongoRepository<Shopping, String> {
  
}
