package com.kwan.shopping.domain.entity;

import com.kwan.shopping.domain.enums.EmployeeStatus;
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
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Employee extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;

  @Column
  private String name;

  @Column
  private  String email;

  @Column
  private String phone;

  @Column
  @Enumerated(EnumType.STRING)
  private EmployeeStatus status;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",
             cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
  public final List<Product> productList = new ArrayList<>();
}
