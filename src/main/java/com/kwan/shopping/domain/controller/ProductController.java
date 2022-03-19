package com.kwan.shopping.domain.controller;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.entity.vo.ProductDetailVo;
import com.kwan.shopping.domain.entity.vo.ProductVo;
import com.kwan.shopping.domain.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

   private final ProductService productService;

   @Autowired
    public ProductController(ProductService productService){
       this.productService = productService;

   }

    @GetMapping(value = "/detail/{productId}")
    public ProductDetailVo productDetailVo(@PathVariable Long productId){
      return productService.productDetailVo(productId);
    }

    @GetMapping(value = "/{page}")
    public List<ProductVo> productVoList (@PathVariable int page){

       return productService.productPage(page);
    }
}
