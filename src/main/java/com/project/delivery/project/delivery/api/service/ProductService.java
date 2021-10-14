package com.project.delivery.project.delivery.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.project.delivery.project.delivery.api.model.Product;
import com.project.delivery.project.delivery.api.repository.ProductRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductNotificationService productNotificationService;

  public List<Product> findProduct(String filter) {
    return productRepository.findAllByText(filter);
  }

  public Product createProduct(Product product) {
    product.setPrefixes(getPrefixes(product.getName()));
    product.setLastTimeAdded(Instant.now());

    var saved = productRepository.save(product);
    productNotificationService.notifyNewProduct(product);
    return saved;
  }

  public List<Product> getAllOrderByLastTimeAdded() {
    return productRepository.findAll(Sort.by("lastTimeAdded").descending());
  }

  private List<String> getPrefixes(String text) {
    String prefix = "";
    List<String> prefixes = new ArrayList<>();

    for (int i = 0; i < text.length(); i++) {
      prefix += text.charAt(i);
      prefixes.add(prefix);
    }

    return prefixes;
  }
}
