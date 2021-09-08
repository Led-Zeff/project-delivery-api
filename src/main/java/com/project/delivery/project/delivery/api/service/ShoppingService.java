package com.project.delivery.project.delivery.api.service;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Shopping;
import com.project.delivery.project.delivery.api.repository.ShoppingRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoppingService {
  private final ShoppingRepository shoppingRepository;
  private final ShoppingNotificationService shoppingNotificationService;

  public List<Shopping> list() {
    return shoppingRepository.findAll();
  }

  public Shopping addShoppingItem(Shopping shopping) {
    Shopping inserted = shoppingRepository.insert(shopping);
    shoppingNotificationService.notifyNewShopping(inserted);
    return inserted;
  }
}
