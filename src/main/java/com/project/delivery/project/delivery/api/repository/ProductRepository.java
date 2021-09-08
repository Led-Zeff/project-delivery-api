package com.project.delivery.project.delivery.api.repository;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {
  @Query(value = "{ $text: { $search: ?0 } }", sort = "{ score: { $meta: \"textScore\" } }")
  List<Product> findAllByText(String text);
}
