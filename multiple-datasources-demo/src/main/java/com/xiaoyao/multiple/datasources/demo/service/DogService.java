package com.xiaoyao.multiple.datasources.demo.service;

import com.xiaoyao.multiple.datasources.demo.entity.one.Dog;
import com.xiaoyao.multiple.datasources.demo.mapper.one.DogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yls
 * @ClassName DogService
 * @Description
 * @Date 2021/4/16 13:44
 * @Version 1.0
 */
@Service
public class DogService {
  @Autowired
  private DogMapper dogMapper;

  public Dog getById(String id) {
    return dogMapper.selectByPrimaryKey(Long.parseLong(id));
  }
}
