package com.kwan.shopping.domain.entity.vo;

import lombok.Getter;

@Getter
public class ProductDetailVo {

  private long price;
  private long salePrice;
  private String name;
  private String url;

  public ProductDetailVo (long price ,long salePrice, String name, String url){
     this.price = price;
     this.salePrice = salePrice;
     this.name = name;
     this.url =url;
  }

}
