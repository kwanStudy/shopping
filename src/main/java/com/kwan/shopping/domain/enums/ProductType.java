package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum ProductType {

  protein( "보충제"),
  AssistDevice("보조기구")
  ;




  ProductType( String title){

    this.title = title;
  }


  private String title;
}
