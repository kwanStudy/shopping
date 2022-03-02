package com.kwan.shopping.domain.repository;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.enums.ProductType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByProductType(ProductType type);

}
