package com.project.delivery.project.delivery.api.service;

import com.project.delivery.project.delivery.api.dto.ShoppingEventDto;
import com.project.delivery.project.delivery.api.dto.ShoppingEventType;
import com.project.delivery.project.delivery.api.model.Shopping;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

//@ConfigurationProperties(prefix = "shopping.notification.service")
@Service
public class ShoppingNotificationService extends NotificationService<ShoppingEventDto<?>> {
  public static final String PREFIX = "/shopping";

  public ShoppingNotificationService(SimpMessagingTemplate template) {
    super(PREFIX, template);
  }

  public void notifyNewShopping(Shopping shopping) {
    broadcast(new ShoppingEventDto<Shopping>(ShoppingEventType.NEW, shopping));
  }
}
