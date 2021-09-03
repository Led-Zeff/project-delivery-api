package com.project.delivery.project.delivery.api.controller;

import com.project.delivery.project.delivery.api.dto.ShoppingEventDto;
import com.project.delivery.project.delivery.api.service.ShoppingNotificationService;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
  @SendTo(ShoppingNotificationService.prefix)
  public ShoppingEventDto<?> broadcastMessage(@Payload ShoppingEventDto<?> event) {
    return event;
  }
}
