package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum ProductType {
 // 생성자 고정시  모두 대문자로 작성 !!
  PROTEIN( "보충제"),
  ASSIST_DEVICE("보조기구")
  ;




  ProductType( String title){

    this.title = title;
  }


  private String title;
}
