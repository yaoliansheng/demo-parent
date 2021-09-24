package com.xiaoyao.multiple.datasources.demo.service;

import com.xiaoyao.multiple.datasources.demo.entity.two.Cat;
import com.xiaoyao.multiple.datasources.demo.mapper.one.DogMapper;
import com.xiaoyao.multiple.datasources.demo.mapper.two.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yls
 * @ClassName CatService
 * @Description
 * @Date 2021/4/16 13:44
 * @Version 1.0
 */
@Service
public class CatService {

  @Autowired
  private CatMapper catMapper;

  public Cat getById(String id) {
    return catMapper.selectByPrimaryKey(Long.parseLong(id));
  }
}
