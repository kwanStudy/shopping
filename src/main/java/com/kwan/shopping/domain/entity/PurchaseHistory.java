package com.kwan.shopping.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class PurchaseHistory extends BaseEntity {

  @Id //PK 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 !!!
  private Long purchaseHistoryId;  //wrapper 클래스 ?
  //  wrapper 클래스를 사용하는 이유 :  Integer / int  Long/ long
  // character / char   db 의 컬럼값이 null 인경우가 에러가 발생하기때문에
  // wrapper 클래스를 사욯해야함.
  // 회색은 아직 사용을 하지않은 것들

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "purchaseHistoryGroupId") //
  private  PurchaseHistoryGroup purchaseHistoryGroup;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productId") //
  private  Product product;

  @Column
  private Long productId;

  @Column
  private Long purchaseHistoryGroupId;

  @Column
  private Integer count;

}
