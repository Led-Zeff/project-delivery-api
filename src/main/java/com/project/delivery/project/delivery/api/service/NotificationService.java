package com.project.delivery.project.delivery.api.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class NotificationService<T> {
  private final String prefix;
  private final SimpMessagingTemplate messagingTemplate;

  protected void broadcast(T payload) {
    messagingTemplate.convertAndSend(prefix, payload);
  }

  protected void broadcast(String destination, T payload) {
    messagingTemplate.convertAndSend(prefix + destination, payload);
  }
}
