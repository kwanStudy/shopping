package com.kwan.shopping.domain.repository;

import com.kwan.shopping.domain.entity.PurchaseHistoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryGroupRepository extends JpaRepository<PurchaseHistoryGroup, Long> {


}
