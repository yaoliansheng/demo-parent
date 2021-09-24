package com.xiaoyao.mapstruct.demo.controller;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.xiaoyao.mapstruct.demo.converter.PersonConverter;
import com.xiaoyao.mapstruct.demo.dto.PersonDTO;
import com.xiaoyao.mapstruct.demo.entity.Person;
import com.xiaoyao.mapstruct.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.MappedByteBuffer;

/**
 * @author yls
 * @ClassName DemoController
 * @Description
 * @Date 2021/3/30 19:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "测试")
public class DemoController {

  @Autowired
  private PersonService personService;

  @Autowired
  private PersonConverter personConverter;

  @Autowired
  IdGenerator idGenerator;

  @GetMapping("get/{id}")
  @ApiOperation("根据ID查询")
  public PersonDTO getById(@PathVariable("id")@ApiParam("人主建ID") Long id){
    Person person = personService.getById(id);
    PersonDTO personDTO = personConverter.toDTO(person);
    PersonConverter mapper = Mappers.getMapper(PersonConverter.class);
    PersonDTO personDTO1 = mapper.toDTO(person);
    return personDTO;
  }

}
