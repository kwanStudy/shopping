package com.kwan.shopping.domain.exception;


import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private int code;
  private String message;

  CustomException(int code , String message){
    this.code = code;
    this.message = message;
  }
  public CustomException(CustomExceptionStatus status){
    this.code = status.getCode();
    this.message = status.getMessage();
  }
}
