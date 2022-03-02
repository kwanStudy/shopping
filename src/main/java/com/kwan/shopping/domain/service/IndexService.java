package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.entity.vo.ProductDetailVo;
import com.kwan.shopping.domain.entity.vo.ProductVo;
import com.kwan.shopping.domain.enums.ProductType;
import com.kwan.shopping.domain.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

  private ProductRepository productRepository;

  @Autowired
  public IndexService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  // dao 를  vo 로 변환하는방법 !!!   21 ~ 57줄
  public List<ProductVo> findAll() { // 인덱스 페이지 전체

    List<Product> productList = productRepository.findAll();
    List<ProductVo> productVoList = new ArrayList<>();

    for(Product product : productList) {
      productVoList.add(product.convertToProductVo());
    }

    return productVoList;

  }


  public List<ProductVo> findAssistDevice() {  // 인덱스 페이지 보조기구
    List<Product> productList = productRepository.findByProductType(ProductType.ASSIST_DEVICE);
    List<ProductVo> productVoList = new ArrayList<>();

    for(Product product : productList){
      productVoList.add(product.convertToProductVo());
    }
    return productVoList;

  }

  public List<ProductVo> findClothes(){ //인덱스 페이지 옷

    List<Product> productList =  productRepository.findByProductType(ProductType.CLOTHES);
    List<ProductVo> productVoList = new ArrayList<>();

    for(Product product : productList){
      productVoList.add(product.convertToProductVo());

    }
    return productVoList;
  }
  public ProductDetailVo detailPage(Long id){  //상세페이지

    Product product = productRepository.findById(id).get();
    ProductDetailVo productDetailVo = product.convertToProductDetailVo();

    return productDetailVo;

  }

}
