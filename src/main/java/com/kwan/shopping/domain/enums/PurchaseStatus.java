package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum PurchaseStatus {

  COMPLETE("001", "결제 완료"),
  WAIT("002", "결제 대기"),
  CANCEL("003", "결제 취소")
  ;

  PurchaseStatus(String code, String title) {
    this.code = code;
    this.title = title;
  }

  private String code;
  private String title;

}
