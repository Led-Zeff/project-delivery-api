package com.project.delivery.project.delivery.api.controller;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Shopping;
import com.project.delivery.project.delivery.api.service.ShoppingService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("shopping")
@RequiredArgsConstructor
public class ShoppingController {
  private final ShoppingService shoppingService;

  @GetMapping
  public List<Shopping> getShopping() {
    return shoppingService.list();
  }

  @PostMapping
  public Shopping addShopping(@RequestBody Shopping shopping) {
    return shoppingService.addShoppingItem(shopping);
  }
}
