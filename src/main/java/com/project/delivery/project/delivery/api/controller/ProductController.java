package com.project.delivery.project.delivery.api.controller;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Product;
import com.project.delivery.project.delivery.api.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping("/search/{query}")
  public List<Product> findProducts(@PathVariable String query) {
    return productService.findProduct(query);
  }

  @PostMapping
  public Product addProduct(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  @GetMapping("/recent")
  public List<Product> getRecentProducts() {
    return productService.getAllOrderByLastTimeAdded();
  }
}
