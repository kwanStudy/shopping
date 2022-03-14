package com.kwan.shopping.domain.enums;


import lombok.Getter;

@Getter
public enum CustomExceptionStatus {

  SUCCESS(0,"성공"),
  FAIL(1,"실패"),
  NOT_ZERO(10, "분모는 0이면 안됩니다."),
  EXISTS_EMAIL(11, "이메일이 존재합니다."),
  NOT_EXISTS_EMAIL(12, "이메일 또는 비밀번호가 틀렸습니다."),
  NOT_AUTH(13, "잘못된 권한 접근입니다."),
  UNEXPECTED_ERROR(999, "예기치 못한 오류가 발생하였습니다.")
  ;

  CustomExceptionStatus(int code, String message){
    this.code = code;
    this.message = message;
  }

  private int code;
  private String message;

}