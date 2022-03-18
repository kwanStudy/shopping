package com.kwan.shopping.domain.config;

import com.kwan.shopping.domain.annotation.AuthCheck;
import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import com.kwan.shopping.domain.exception.CustomException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor { //프런트보내면  서블릿을 먼저 지나고 controller로 이동 할때 intercepter 발동된다.

  private final JwtTokenProvider jwtTokenProvider;

  @Override                 //프론트에서요청 온것들         ///프론트로 돌려주는 !!
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    //controller에 Annotation @AuthCheck가 붙어있는지 확인
    boolean hasAnnotation = checkAnnotation(handler, AuthCheck.class);
    if(hasAnnotation){
      //어노테이션이 있으면서, User의 정보가 맞다면 true 반환
      //request에서 session 받아오기
      HttpSession session = request.getSession();
      String email = (String) session.getAttribute("email");
//      String token = (String) session.getAttribute("token");//redis session에 저장된 객체 반환
//      String token = request.getHeader("authentication");

      //jwt토큰을 확인하여 유효성 검증
//      if(jwtTokenProvider.validateToken(token)) {
//        return true;
//      }
      if(email != null) {
        return true;
      }

      session.invalidate();
      throw new CustomException(CustomExceptionStatus.NOT_AUTH);
    }
    return true; //모두에게 공개되는 컨트롤러
  }

  private boolean checkAnnotation(Object handler, Class<AuthCheck> authClass) {
    //front(html, js)관련 파일은 통과
    if (handler instanceof ResourceHttpRequestHandler) {
      return true;
    }

    HandlerMethod handlerMethod = (HandlerMethod) handler;

    //Auth anntotation이 있는 경우
    if (null != handlerMethod.getMethodAnnotation(authClass) || null != handlerMethod.getBeanType().getAnnotation(authClass)) {
      return true;
    }
    return false;
  }
}
