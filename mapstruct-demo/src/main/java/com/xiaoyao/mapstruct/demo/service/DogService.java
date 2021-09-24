package com.xiaoyao.mapstruct.demo.service;

import com.xiaoyao.mapstruct.demo.entity.Dog;
import com.xiaoyao.mapstruct.demo.mapper.DogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yls
 * @ClassName DogService
 * @Description
 * @Date 2021/3/30 19:48
 * @Version 1.0
 */
@Service
public class DogService {

  @Autowired
  private DogMapper dogMapper;

  public Dog getById(Long id){
    return dogMapper.selectByPrimaryKey(id);
  }
}
