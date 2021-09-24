package com.xiaoyao.mapstruct.demo.dto;

import lombok.Data;

/**
 * @author yls
 * @ClassName PersonInfDTO
 * @Description
 * @Date 2021/3/31 11:00
 * @Version 1.0
 */
@Data
public class PersonInfDTO {

  private String id;

  private String name;

  private Integer age;

  private Long dogId;

  private String dogName;

  private Integer dogAge;

  private Long catId;

  private String catName;

  private Integer catAge;
}
