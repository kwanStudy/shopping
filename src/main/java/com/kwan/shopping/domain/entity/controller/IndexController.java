package com.kwan.shopping.domain.entity.controller;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.entity.vo.ProductVo;
import com.kwan.shopping.domain.service.IndexService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

  private IndexService indexService;

  @Autowired
  public IndexController(IndexService indexService){
    this.indexService = indexService;
  }

  @GetMapping(value = "/findAll")
  public List<ProductVo> findAll() {
    return indexService.findAll();
  }

  @GetMapping(value = "/assistDevice")
  public List<ProductVo> findAssistDevice() {
    return indexService.findAssistDevice();
  }

  @GetMapping(value = "/clothes")
  public List<ProductVo> findClothes(){
    return indexService.findClothes();
  }


}
