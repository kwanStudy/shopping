package com.kwan.shopping.domain.entity;

import com.kwan.shopping.domain.enums.EmployeeStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
