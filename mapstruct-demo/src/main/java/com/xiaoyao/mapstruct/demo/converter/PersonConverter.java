package com.xiaoyao.mapstruct.demo.converter;

import com.xiaoyao.mapstruct.demo.dto.PersonDTO;
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
public abstract class PersonConverter implements BaseConverter<PersonDTO, Person>{

  @Autowired
  protected CatService catService;

  @Autowired
  protected DogService dogService;

  @Mappings({
      @Mapping(target = "dog", expression = "java(dogService.getById(person.getDogId()))"),
      @Mapping(target = "cat", expression = "java(catService.getById(person.getCatId()))")
  })
  @Override
  public abstract PersonDTO toDTO(Person person);
}
