package com.xiaoyao.mapstruct.demo.converter;

import com.xiaoyao.mapstruct.demo.dto.PersonDTO;
import com.xiaoyao.mapstruct.demo.dto.PersonInfDTO;
import com.xiaoyao.mapstruct.demo.entity.Cat;
import com.xiaoyao.mapstruct.demo.entity.Dog;
import com.xiaoyao.mapstruct.demo.entity.Person;
import com.xiaoyao.mapstruct.demo.service.CatService;
import com.xiaoyao.mapstruct.demo.service.DogService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yls
 * @ClassName PersonConverter
 * @Description
 * @Date 2021/3/30 19:40
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public abstract class DemoConverter {

  @Autowired
  protected CatService catService;

  @Autowired
  protected DogService dogService;

  /**
   * expression 这里可以写java代码会直接映射到方法
   *
   * @param person
   * @return
   */
  @Mappings({
      @Mapping(target = "dog", expression = "java(dogService.getById(person.getDogId()))"),
      @Mapping(target = "cat", expression = "java(catService.getById(person.getCatId()))")
  })
  public abstract PersonDTO toDTO(Person person);

  @Mappings({
      @Mapping(target = "id", source = "person.id"),
      @Mapping(target = "name", source = "person.name"),
      @Mapping(target = "age", source = "person.age"),
  })
  public abstract PersonDTO toDTO(Person person, Cat cat, Dog dog);

  @Mappings({
      @Mapping(target = "id", source = "person.id"),
      @Mapping(target = "name", source = "person.name"),
      @Mapping(target = "age", source = "person.age"),
      @Mapping(target = "dogName", source = "dog.name"),
      @Mapping(target = "dogAge", source = "dog.age"),
      @Mapping(target = "catName", source = "cat.name"),
      @Mapping(target = "catAge", source = "cat.age")
  })
  public abstract PersonInfDTO toInfDTO(Person person, Cat cat, Dog dog);

}
