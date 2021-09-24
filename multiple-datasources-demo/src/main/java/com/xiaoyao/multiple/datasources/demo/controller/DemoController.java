package com.xiaoyao.multiple.datasources.demo.controller;

import com.xiaoyao.multiple.datasources.demo.entity.one.Dog;
import com.xiaoyao.multiple.datasources.demo.entity.two.Cat;
import com.xiaoyao.multiple.datasources.demo.service.CatService;
import com.xiaoyao.multiple.datasources.demo.service.DogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yls
 * @ClassName DogController
 * @Description
 * @Date 2021/4/16 13:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

  @Autowired
  private DogService dogService;

  @Autowired
  private CatService catService;

  @GetMapping("dog/{id}")
  @ApiOperation("根据ID获取狗")
  public Dog getDogById(@PathVariable("id") @ApiParam("主建ID") String id){
    return dogService.getById(id);
  }

  @GetMapping("cat/{id}")
  @ApiOperation("根据ID获取猫")
  public Cat getCatById(@PathVariable("id") @ApiParam("主建ID") String id){
    return catService.getById(id);
  }
}
