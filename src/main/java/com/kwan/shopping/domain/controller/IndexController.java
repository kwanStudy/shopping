package com.kwan.shopping.domain.controller;

import com.kwan.shopping.domain.entity.Product;
import com.kwan.shopping.domain.entity.vo.ProductVo;
import com.kwan.shopping.domain.enums.CustomExceptionStatus;
import com.kwan.shopping.domain.exception.CustomException;
import com.kwan.shopping.domain.service.IndexService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index") //요청에 대해 어떤 Controller , 어떤 메소드가 처리할지 맵핑하기 위한 어노테이션
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

  @GetMapping(value = "/test")
  public float test(@RequestParam int cnt) {
    if(cnt == 0) {
      throw new CustomException(CustomExceptionStatus.NOT_ZERO);
    }
    float result = 1/cnt;
    return result;

//    throw new CustomException(CustomExceptionStatus.SUCCESS);
  }





}
