package com.kwan.shopping.domain.controller;

import com.kwan.shopping.domain.entity.PurchaseHistoryGroup;
import com.kwan.shopping.domain.service.PurchaseHistoryGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value ="/mypage") //Controller 에서는 get post put del 메소드를  다 받아야하므로  @requestMapping 을 사용해야함!!
// ex localhost/mypage/purchaseHistory 28줄(findBuyPrduct가 이 실행된다.
public class PurchaseHistoryGroupController {

  private PurchaseHistoryGroupService purchaseHistoryGroupService;
  //서비스를 불러오기 위해 선언


  @Autowired // 의존성 주입
  public PurchaseHistoryGroupController(PurchaseHistoryGroupService purchaseHistoryGroupService){
    this.purchaseHistoryGroupService = purchaseHistoryGroupService;  //생성자 생성
  }

  @GetMapping(value = "/purchaseHistory") //데이터를 가져오기때문에 Get  url 임의적으로 추가
  public List<PurchaseHistoryGroup> findBuyProduct(String email){  // String email 사용자 이메일을 통해 User 객체를 찾는다.
      return purchaseHistoryGroupService.findBuyProduct(email);
  }



}
