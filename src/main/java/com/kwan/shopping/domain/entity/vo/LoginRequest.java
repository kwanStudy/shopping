package com.kwan.shopping.domain.entity.vo;

import lombok.Getter;

@Getter
public class LoginRequest {
//
//  private String email;
//  private String password;
//
//  public LoginRequest(String email, String password) {
//    this.email = email;
//    this.password = password;
//  }


   private String email;
   private String password;

   public LoginRequest(String email , String password){
     this.email = email;
     this. password = password;
   }

}
