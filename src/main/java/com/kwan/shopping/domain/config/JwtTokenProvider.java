package com.kwan.shopping.domain.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  private String secretKey = "kwanTest";

  private final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 30; // 30분

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  } //hash화  :  난수로 만들어 암호화를한다.  //암호화 종류 : Base64

  //토큰 생성
  public String createToken(String email, String name, long userId) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("email", email);
    claims.put("name", name);
    claims.put("userId", userId);

    Date now = new Date();
    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now) //jwt 발급한 시간
        .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALID_TIME)) //jwt 유효기간
        .signWith(SignatureAlgorithm.HS256, secretKey) //암호화 종류 : HS256
        .compact();
  }
   //back(body) - > font(head) -> back (이때부터 인증/ 유효성을 체크한다) 이떄부터 정해놓은 시간동안 사용가능
  // 토큰에서 회원 정보 추출
  public String getUserEmail(String token) {
    return String.valueOf(Jwts.parser()
        .setSigningKey(secretKey)  //암호화된것을 다시 원상태로 만든다.
        .parseClaimsJws(token)
        .getBody()
        .get("email"));
  }

  // 토큰의 유효성 + 만료일자 확인
  public boolean validateToken(String jwtToken) {
    try {
      Jws<Claims> claims = Jwts.parser()
          .setSigningKey(secretKey)
          .parseClaimsJws(jwtToken);
      System.out.println(claims.getBody());
      String data = String.valueOf(claims.getBody().get("name"));
      System.out.println(data);

      return claims.getBody() //토큰 만들고 8시 30분 ~ 9시
          .getExpiration() // 유효시간 확인
          .after(new Date());  //33분 이후에 유효성시간 남아있는 토큰 내보내겟다 ?
    } catch (Exception e) {
      return false;
    }
  }

}
