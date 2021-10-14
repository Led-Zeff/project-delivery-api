package com.project.delivery.project.delivery.api.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "products")
public class Product {
  @Id
  private String id;
  private String name;
  private Instant lastTimeAdded;
  private List<String> prefixes;
}
