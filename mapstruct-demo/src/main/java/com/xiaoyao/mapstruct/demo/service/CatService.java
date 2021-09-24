package com.xiaoyao.mapstruct.demo.service;

import com.xiaoyao.mapstruct.demo.entity.Cat;
import com.xiaoyao.mapstruct.demo.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yls
 * @ClassName CatService
 * @Description
 * @Date 2021/3/30 19:48
 * @Version 1.0
 */
@Service
public class CatService {

  @Autowired
  private CatMapper catMapper;

  public Cat getById(Long id){
    return catMapper.selectByPrimaryKey(id);
  }

}
