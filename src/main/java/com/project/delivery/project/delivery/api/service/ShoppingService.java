package com.project.delivery.project.delivery.api.service;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Product;
import com.project.delivery.project.delivery.api.model.Shopping;
import com.project.delivery.project.delivery.api.repository.ShoppingRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoppingService {
  private final ShoppingRepository shoppingRepository;
  private final ShoppingNotificationService shoppingNotificationService;
  private final ProductService productService;

  public List<Shopping> list() {
    return shoppingRepository.findAll();
  }

  public Shopping addShoppingItem(Shopping shopping) {
    if (!StringUtils.hasText(shopping.getProduct().getProductId())) {
      var product = Product.builder()
        .name(shopping.getProduct().getName())
        .build();
      var saved = productService.createProduct(product);
      shopping.getProduct().setProductId(saved.getId());
    }

    var inserted = shoppingRepository.insert(shopping);
    shoppingNotificationService.notifyNewShopping(inserted);
    return inserted;
  }
}
