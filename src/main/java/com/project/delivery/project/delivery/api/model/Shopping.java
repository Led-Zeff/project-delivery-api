package com.project.delivery.project.delivery.api.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "shopping")
public class Shopping {
  @Id
  private String id;
  private ShoppingProduct product;
  private Integer quantity;
  
  @CreatedDate
  private Instant createTime;
}
