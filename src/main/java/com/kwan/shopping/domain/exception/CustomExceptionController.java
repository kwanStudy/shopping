package com.kwan.shopping.domain.exception;


import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j //로그찍어주는 어노테이션
@RestControllerAdvice // 이 어노테이션 이 프로젝트안에있는 throws 관리할수있음
public class CustomExceptionController {


//  @ExceptionHandler(CustomException.class)
//  public ResponseEntity<BaseResponse> customException(CustomException e) {
//    //BaseResponse를 사용하는 이유 : runtimeException를 상속받아  모든 변수를 반환하기때문에 BaseResponse를 사용하여 원하는 변수만 나오도록 설정한 것!
//
//    log.error("Error Code : {}", e.getCode()); //{} 자리에 e.getCode()의 결과가 대체된다.
//    log.error("Error Message : {}", e.getMessage());
//
//    return new ResponseEntity<>(new BaseResponse(e), HttpStatus.OK);
//  }
//
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<BaseResponse> outOfCustomException(Exception e) {
//    log.error("Error Code : {}", CustomExceptionStatus.UNEXPECTED_ERROR.getCode());
//    log.error("Error Message : {}", CustomExceptionStatus.UNEXPECTED_ERROR.getMessage());
//
//    return new ResponseEntity<>(new BaseResponse(CustomExceptionStatus.UNEXPECTED_ERROR),
//                                HttpStatus.OK);
//  }

  public ResponseEntity<BaseResponse> customException(CustomException e){

    log.error("Error Code:{}",e.getCode());
    log.error("Error Message: {}",e.getMessage());

    return new ResponseEntity<>(new BaseResponse(e), HttpStatus.OK);
  }

  public ResponseEntity<BaseResponse> outofCustomException(Exception e){
     log.error("Error : Code : {}", CustomExceptionStatus.UNEXPECTED_ERROR.getCode());
     log.error("Error : Message : {}", CustomExceptionStatus.UNEXPECTED_ERROR.getMessage());

     return new ResponseEntity<>(new BaseResponse(CustomExceptionStatus.UNEXPECTED_ERROR),HttpStatus.OK);
  }
}
