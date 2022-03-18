package com.kwan.shopping.domain.controller;

import com.kwan.shopping.domain.entity.vo.LoginRequest;
import com.kwan.shopping.domain.entity.vo.SignUpRequest;
import com.kwan.shopping.domain.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러 는 상대방에 요청올때 사용되는 클래스이며, 주로 가볍게 만든다.
@RestController
@RequiredArgsConstructor // 생성자 주입
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

//  @PostMapping("/login")
//  public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
//    return userService.login(request, session);
//  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody LoginRequest request, HttpSession session) {
    return userService.login(request, session);
  }

  @PostMapping("/signUp")
  public ResponseEntity<Object> signUp(@RequestBody SignUpRequest request) {
    return userService.signUp(request);
  }

}
