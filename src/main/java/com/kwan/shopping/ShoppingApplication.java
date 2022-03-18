package com.kwan.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableJpaAuditing
@EnableRedisHttpSession // http 세션을 부르면 레디스에 접근!
@SpringBootApplication
public class ShoppingApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingApplication.class, args);
  }

}
