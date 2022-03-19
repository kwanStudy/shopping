package com.kwan.shopping.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration  //Bean에 등록하는 어노테이션
@EnableRedisRepositories // 레디스레포지토리 추가 !
public class RedisConfig {

  private String host = "localhost";
  private int port = 6379;

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    return new LettuceConnectionFactory(host, port); //레디스랑 연결해주는 함수
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {  //RedisTemplate 기초적인 레디스 설정
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    // 아래 두 라인을 작성하지 않으면, key값이 \xac\xed\x00\x05t\x00\x03sol 이렇게 조회된다.
    // 아래 네개는 외우기  키값을 내가 있는 값으로 변경해주는 설정
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setEnableTransactionSupport(true);
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setConnectionFactory(redisConnectionFactory());

    return redisTemplate;
  }


}
