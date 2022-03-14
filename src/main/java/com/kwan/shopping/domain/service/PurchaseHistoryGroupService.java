package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.config.JwtTokenProvider;
import com.kwan.shopping.domain.entity.PurchaseHistoryGroup;
import com.kwan.shopping.domain.entity.User;
import com.kwan.shopping.domain.entity.vo.LoginRequest;
import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import com.kwan.shopping.domain.exception.CustomException;
import com.kwan.shopping.domain.repository.PurchaseHistoryGroupRepository;
import com.kwan.shopping.domain.repository.UserRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryGroupService {


  private UserRepository userRepository;
  private final JwtTokenProvider jwtTokenProvider;

  //  구매내역을 알기위해, user 정보 먼저 갖고온다.

  public List<PurchaseHistoryGroup> findBuyProduct(HttpServletRequest request) {

    String token = request.getHeader("authentication");//프로튼가 보내준 헤더 토큰을 가져옴
    String email = jwtTokenProvider.getUserEmail(token);//jwt token 바디에있는 이메일을 가져와서 로그인한 USER의 EMAIL을 가져옴
    User user = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(
        CustomExceptionStatus.EXISTS_EMAIL));

    return user.getPurchaseHistoryGroupList();

  } //구내묶음이 여러개 있어 , List 사용하고  유저를 찾기위해 String email 추가   user 정보를 이메일을 통해 찾아서  리턴해준다.



}
