package com.kwan.shopping.domain.enums;

// enums 같이 개발하는사람들끼리의 규칙이라고 생각하면됨
import lombok.Getter;

@Getter
public enum PurchaseStatus {

    COMPLETE("001", "결제 완료"),
  WAIT("002", "결제 대기"),
  CANCEL("003", "결제 취소"),
  ERROR("004","에러")

  ;

  PurchaseStatus(String code, String title) {
    this.code = code;
    this.title = title;
  }

  private String code;
  private String title;

}

