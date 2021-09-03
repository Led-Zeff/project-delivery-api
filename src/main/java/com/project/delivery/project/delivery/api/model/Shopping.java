package com.project.delivery.project.delivery.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "shopping")
@Data
public class Shopping {
  @Id
  private String id;
  private String name;
  private Integer quantity; 
}
