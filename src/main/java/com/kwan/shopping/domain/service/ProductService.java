package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.entity.vo.ProductVo;
import com.kwan.shopping.domain.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductVo> productPage(int page) { //상대방이 알려주는정보

    List<Product> productList = productRepository.findAll(); //productRepository는 db에서 갖고오게 하는 매개물 ?
    List<ProductVo> productVoList = new ArrayList<>();

    for (int i = 9 * (page - 1); i < 9*page; i++) {
      Product product = productList.get(i);
      ProductVo productVo = product.convertToProductVo();
      productVoList.add(productVo);
    }
    return productVoList;
    //페이징!
  }
}