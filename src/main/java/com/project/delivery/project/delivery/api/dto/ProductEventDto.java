package com.project.delivery.project.delivery.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductEventDto <T> {
  private ProductEventType type;
  private T payload;
}
