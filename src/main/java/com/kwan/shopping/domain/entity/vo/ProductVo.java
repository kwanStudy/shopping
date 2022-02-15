package com.kwan.shopping.domain.entity.vo;

import lombok.Getter;

@Getter
public class ProductVo {

  private String name;
  private long realPrice;
  private long salePrice;

  public ProductVo(String name, long realPrice, long salePrice) {
    this.name = name;
    this.realPrice = realPrice;
    this.salePrice = salePrice;
  }

}
