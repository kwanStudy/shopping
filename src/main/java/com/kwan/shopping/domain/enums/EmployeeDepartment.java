package com.kwan.shopping.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeDepartment {

  DEVELOP("개발팀"),
  PERSONNEL("인사팀"),
  DESIGN("디자인팀"),
  MARKETING("마케팅팀")


  ;


  EmployeeDepartment(String name) {
    this.name = name;
  }

  private String name;
}
