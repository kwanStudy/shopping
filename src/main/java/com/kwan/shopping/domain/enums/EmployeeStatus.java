package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeStatus {
  JOIN("입사"),
  RESIGN("퇴사"),
  BREAK("휴직"),





  ;

  EmployeeStatus(String type ) {
    this.type = type;

  }

  private String type;


}
