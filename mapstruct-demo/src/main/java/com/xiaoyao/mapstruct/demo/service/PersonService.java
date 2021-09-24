package com.xiaoyao.mapstruct.demo.service;

import com.xiaoyao.mapstruct.demo.entity.Person;
import com.xiaoyao.mapstruct.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yls
 * @ClassName PersonService
 * @Description
 * @Date 2021/3/30 19:48
 * @Version 1.0
 */
@Service
public class PersonService {

  @Autowired
  private PersonMapper personMapper;

  public Person getById(Long id){
    return personMapper.selectByPrimaryKey(id);
  }

  public void save(Person person) {
    personMapper.insert(person);
  }
}
