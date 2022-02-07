package com.kwan.shopping.domain.repository;

import com.kwan.shopping.domain.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PurchaseHistoryRepository extends JpaRepository<PurchaseHistory , Long> {
//JpaRepository<PurchaseHistory(이거 쓸꺼야~) , Long(pK키 기준으로 타입정하기)>
  //
}
