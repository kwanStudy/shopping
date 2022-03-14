package com.kwan.shopping.domain.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented //어노테이션 기초기능을 설정함(어노테이션을 등록하겠다)
@Retention(RetentionPolicy.RUNTIME)  //런타임할때만 인식하게 하겠다!
@Target({ElementType.METHOD}) //어노테이션을 어디에 붙일지 ~ 메소드니까 함수 !
public @interface AuthCheck {
}
