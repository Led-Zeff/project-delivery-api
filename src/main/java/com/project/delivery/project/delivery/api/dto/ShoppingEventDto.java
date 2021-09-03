package com.project.delivery.project.delivery.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ShoppingEventDto <T> {
  private ShoppingEventType type;
  private T payload;
}
