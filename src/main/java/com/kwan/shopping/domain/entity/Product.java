package com.kwan.shopping.domain.entity;

import com.kwan.shopping.domain.enums.EmployeeDepartment;
import com.kwan.shopping.domain.enums.ProductType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @Column
  private Long employeesID;

  @Column
  private String name;

  @Column
  private Long price;

  @Column
  private String productEx;

  @Column
  private BigDecimal saleRate;

  @Column
  @Enumerated(EnumType.STRING)
  private ProductType Type;

  @Column
  @Enumerated(EnumType.STRING) // DB로 들어갈떄   배열(0,1,2,)으로 들어가는것을  String타입으로 들어가게 변경해줌
  private EmployeeDepartment department;

  @Column
  private String url;

  @OneToMany(fetch = FetchType.LAZY , mappedBy = "product",
             cascade = {CascadeType.MERGE , CascadeType.PERSIST})
  private  final List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employeeId")
  private Employee employee;
  //BigDecimal 소수점까지 표현할떄 사용함  double보다 오차가없지만 메모리가 크며 연산이오래걸림
}
