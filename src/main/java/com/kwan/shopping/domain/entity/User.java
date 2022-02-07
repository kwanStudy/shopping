package com.kwan.shopping.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
 // extends  Base Entity 는 모든 클래스에 생성일자 / 변경일자를  확인하기위해 상속함.
@Entity
@Getter
public class User extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column
  private String name;

  @Column
  private String email;

  @Column
  private String password;

  @Column
  private String address;

  @Column
  private String phone;

  @Column
  private String frontRegNum;

  @Column
  private String endRegNum;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
             cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private final List<PurchaseHistoryGroup> purchaseHistoryGroupList = new ArrayList<>();

  public void test() {
    purchaseHistoryGroupList.stream()
                            .count();
  }

}
