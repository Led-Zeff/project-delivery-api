package com.project.delivery.project.delivery.api.service;

import java.util.List;

import com.project.delivery.project.delivery.api.model.Product;
import com.project.delivery.project.delivery.api.repository.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> findProduct(String filter) {
    return productRepository.findAllByText(filter);
  }
}
