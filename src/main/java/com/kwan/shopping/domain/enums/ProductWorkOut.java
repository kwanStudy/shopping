package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum ProductWorkOut {
  CHEST("가슴"),
  BACK("가슴"),
  SHOULDER("어깨"),
  LOWERBODY("하체"),
  ARM("팔");

  ProductWorkOut(String work) {
    this.work = work;

  }

  private String work;
}
