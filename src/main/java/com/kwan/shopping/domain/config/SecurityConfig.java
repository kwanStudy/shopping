package com.kwan.shopping.domain.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//39  고냥 외우기 //스프링 시큐리티 세션보안관리를 편하게 해주니까 사용 이건 구글에 검색하면 표준 형식이 많음
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { //시큐리티에 기본적인 설정을 잡는다 !

  @Bean  //java 경우 객체를 하나만 설정해서 , 다른 객체들에서 갖다쓰는걸  일단 등록 후 필요할때 갖다쓴다!!  자원낭비방지를 위해서!
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeHttpRequests()
//        .antMatchers("/index", "/user/**").permitAll()
//        .anyRequest().authenticated();
//        .antMatchers("/mypage/**").authenticated()
        .anyRequest().permitAll();
  }
}
