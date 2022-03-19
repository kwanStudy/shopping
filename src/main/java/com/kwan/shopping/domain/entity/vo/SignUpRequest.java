package com.kwan.shopping.domain.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

  private String email;
  private String name;
  private String password;
  private String address;

}
