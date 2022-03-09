package com.kwan.shopping.domain.controller;

import com.kwan.shopping.domain.entity.vo.LoginRequest;
import com.kwan.shopping.domain.entity.vo.SignUpRequest;
import com.kwan.shopping.domain.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

//  @PostMapping("/login")
//  public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
//    return userService.login(request, session);
//  }

  @GetMapping("/login")
  public ResponseEntity<Object> login() {
    LoginRequest request = new LoginRequest("test@test.com", "test1234");
    return userService. login(request);
  }

  @PostMapping("/signUp")
  public ResponseEntity<Object> signUp(@RequestBody SignUpRequest request) {
    return userService.signUp(request);
  }

}
