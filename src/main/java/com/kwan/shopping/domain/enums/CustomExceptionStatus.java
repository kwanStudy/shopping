package com.kwan.shopping.domain.enums;


import lombok.Getter;

@Getter
public enum CustomExceptionStatus {

  SUCCESS(0,"성공"),
  FAIL(1,"실패"),
  NOT_ZERO(10, "분모는 0이면 안됩니다."),
  UNEXPECTED_ERROR(999, "예기치 못한 오류가 발생하였습니다.")
  ;

   CustomExceptionStatus(int code, String message){
    this.code = code;
    this.message = message;
  }

  private int code;
  private String message;
}