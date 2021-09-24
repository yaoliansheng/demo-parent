package com.xiaoyao.mapstruct.demo.entity;

import io.swagger.annotations.ApiModelProperty;

public class Dog {
  @ApiModelProperty("主键ID")
  private Long id;
  @ApiModelProperty("姓名")
  private String name;
  @ApiModelProperty("年龄")
  private Integer age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}