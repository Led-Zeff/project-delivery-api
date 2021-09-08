package com.project.delivery.project.delivery.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "products")
public class Product {
  @Id
  private String id;
  private String name;
}
