package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.entity.PurchaseHistoryGroup;
import com.kwan.shopping.domain.entity.User;
import com.kwan.shopping.domain.entity.vo.LoginRequest;
import com.kwan.shopping.domain.repository.PurchaseHistoryGroupRepository;
import com.kwan.shopping.domain.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String login(LoginRequest loginRequest) {

    User user = userRepository.findByEmail(loginRequest.getEmail()).get();

    if(!user.getPassword().equals(loginRequest.getPassword())) {
      return "비밀번호가 틀렸습니다.";
    }

    return "로그인에 성공하였습니다.";
  }

  public List<PurchaseHistoryGroup> findPurchaseHistoryGroup(String email) {
    User user = userRepository.findByEmail(email).get();

    return user.getPurchaseHistoryGroupList();
  }

}
