package com.kwan.shopping.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
public class BaseEntity {

  @CreatedDate // 데이터 한줄이 언제 생겼는지 / 수정했는지 db가 알아야함  이걸 확인하려는 어노테이션
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate  //최근  수정날짜 어노테이션
  private LocalDateTime updatedAt;

}
