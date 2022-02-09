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
public class PurchaseHistoryGroupService {


  private UserRepository userRepository;

  //  구매내역을 알기위해, user 정보 먼저 갖고온다.

  @Autowired
  public PurchaseHistoryGroupService(UserRepository userRepository){

     this.userRepository = userRepository;
  } // 생성자(틀래스이름과 동일) / 의존성 주입

  public List<PurchaseHistoryGroup> findBuyProduct(String email) {

    User user = userRepository.findByEmail(email).get();

    return user.getPurchaseHistoryGroupList();

  } //구내묶음이 여러개 있어 , List 사용하고  유저를 찾기위해 String email 추가   user 정보를 이메일을 통해 찾아서  리턴해준다.



}
