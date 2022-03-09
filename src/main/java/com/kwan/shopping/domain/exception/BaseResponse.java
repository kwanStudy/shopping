package com.kwan.shopping.domain.exception;


import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import lombok.Getter;

@Getter
public class BaseResponse {
//  private int code;
//  private String message;
//
//   public BaseResponse(int code, String message){
//    this.code = code;
//    this.message = message;
//  }
//
//  public  BaseResponse(CustomException e){
//    this.code = e.getCode();
//    this.message = e.getMessage();
//  }
//
//  public BaseResponse(CustomExceptionStatus status){
//    this.code = status.getCode();
//    this.message = status.getMessage();
//
//  }
  private int code;
  private String message;

  public BaseResponse(int code, String message){
    this.code = code;
    this.message = message;

  }

  public BaseResponse(CustomException e){
    this.code= e.getCode();
    this.message = e.getMessage();

  }

  public BaseResponse(CustomExceptionStatus status){
    this.code = status.getCode();
    this.message =status.getMessage();
  }

}
