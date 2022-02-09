package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.enums.ProductType;
import com.kwan.shopping.domain.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

  private ProductRepository productRepository;

  @Autowired
  public IndexService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public List<Product> findAssistDevice() {
    return productRepository.findByType(ProductType.ASSIST_DEVICE);
  }

  public List<Product> findClothes(){
    return productRepository.findByType(ProductType.CLOTHES);
  }

}
