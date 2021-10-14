package com.project.delivery.project.delivery.api.service;

import com.project.delivery.project.delivery.api.dto.ProductEventDto;
import com.project.delivery.project.delivery.api.dto.ProductEventType;
import com.project.delivery.project.delivery.api.model.Product;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductNotificationService extends NotificationService<ProductEventDto<?>> {
  public static final String PREFIX = "/products";

  public ProductNotificationService(SimpMessagingTemplate template) {
    super(PREFIX, template);
  }

  public void notifyNewProduct(Product product) {
    this.broadcast(new ProductEventDto<Product>(ProductEventType.NEW, product));
  }
}
