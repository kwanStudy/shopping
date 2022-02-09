package com.kwan.shopping.domain.entity;

import com.kwan.shopping.domain.enums.PurchaseStatus;
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
public class PurchaseHistoryGroup extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long purchaseHistoryGroupId;

  @Column
  @Enumerated(value = EnumType.STRING)
  private PurchaseStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userId") // joincoium 외래키 ! user.class  id와 연동시킴
  private User user;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseHistoryGroup",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private final List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

  public void setStatus(PurchaseStatus status) {
    this.status = status;
  }

  public void modify() {
    setStatus(PurchaseStatus.COMPLETE);
  }

}
