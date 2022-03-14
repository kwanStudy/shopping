package com.kwan.shopping.domain.service;

import com.kwan.shopping.domain.config.JwtTokenProvider;
import com.kwan.shopping.domain.entity.PurchaseHistoryGroup;
import com.kwan.shopping.domain.entity.User;
import com.kwan.shopping.domain.entity.vo.LoginRequest;
import com.kwan.shopping.domain.entity.vo.SignUpRequest;
import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import com.kwan.shopping.domain.exception.CustomException;
import com.kwan.shopping.domain.repository.PurchaseHistoryGroupRepository;
import com.kwan.shopping.domain.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//39
@Slf4j
@Service
@RequiredArgsConstructor // 생성자를 생성주는 어노테이션 !!!
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  public ResponseEntity<Object> login(LoginRequest request) {

//    Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
//    User user = optionalUser.orElseThrow();//if( object == null)

    User user = userRepository
        .findByEmail(request.getEmail())
        .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXISTS_EMAIL));

    if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {//(암호화전 비번, 암호화 비번)
      throw new CustomException(CustomExceptionStatus.NOT_EXISTS_EMAIL);
    }

    String token = jwtTokenProvider.createToken(user.getEmail(), user.getName(), user.getUserId());

    return ResponseEntity.ok().body(token);
  }

  public ResponseEntity<Object> signUp(SignUpRequest request) {

    if(userRepository.existsByEmail(request.getEmail())) {
      throw new CustomException(CustomExceptionStatus.EXISTS_EMAIL);
    }
    String encodePassword = passwordEncoder.encode(request.getPassword());
    User user = new User(request, encodePassword);
    userRepository.save(user);

    return ResponseEntity.ok(user);
  }

  public List<PurchaseHistoryGroup> findPurchaseHistoryGroup(String email) {
    User user = userRepository.findByEmail(email).get();

    return user.getPurchaseHistoryGroupList();
  }

//   private final UserRepository userRepository;
//   private final PasswordEncoder passwordEncoder;
//
//   public ResponseEntity<Object> login(LoginRequest request){
// User user = userRepository
//     .findByEmail((request.getEmail()))
//     .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXISTS_EMAIL));
//
// if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
//  throw new CustomException((CustomExceptionStatus.NOT_EXISTS_EMAIL));
//     }
//   return  ResponseEntity.ok().build();
//   }
//   public ResponseEntity<Object> signUp(SignUpRequest request){
//      if(userRepository.existsByEmail(request.getEmail())){
//        throw  new CustomException(CustomExceptionStatus.EXISTS_EMAIL);
//     }
//     String encodePassword = passwordEncoder.encode(request.getPassword());
//      User user = new User(request, encodePassword);
//      userRepository.save(user);
//
//      return ResponseEntity.ok(user);
//   }
//  public List<PurchaseHistoryGroup> findPurchaseHistoryGroup(String email) {
//    User user = userRepository.findByEmail(email).get();
//
//    return user.getPurchaseHistoryGroupList();
//  }

}
