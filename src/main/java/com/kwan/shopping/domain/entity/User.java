package com.kwan.shopping.domain.entity;

import com.kwan.shopping.domain.entity.vo.SignUpRequest;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// extends  Base Entity 는 모든 클래스에 생성일자 / 변경일자를  확인하기위해 상속함.
@Entity
@Getter
public class User extends BaseEntity {

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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",// onetomany 에서 to 뒤에 many 경우 리스트로 받고 one 경우 객체로 받음
             cascade = {CascadeType.MERGE, CascadeType.PERSIST}) // 병함 / 생성 or 변경
  private final List<PurchaseHistoryGroup> purchaseHistoryGroupList = new ArrayList<>();

  public User(SignUpRequest request, String password) {
    this.name = request.getName();
    this.email = request.getEmail();
    this.password = password;  //암호화된 패스워드
    this.address = request.getAddress();
  }

   public User() {

   }
}
