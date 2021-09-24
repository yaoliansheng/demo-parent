package com.xiaoyao.mapstruct.demo.dto;

import com.xiaoyao.mapstruct.demo.entity.Cat;
import com.xiaoyao.mapstruct.demo.entity.Dog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yls
 * @ClassName PersonDTO
 * @Description
 * @Date 2021/3/30 19:44
 * @Version 1.0
 */
@Data
public class PersonDTO {
  @ApiModelProperty("主键ID")
  private Long id;
  @ApiModelProperty("姓名")
  private String name;
  @ApiModelProperty("年龄")
  private Integer age;
  @ApiModelProperty("猫")
  private Cat cat;
  @ApiModelProperty("狗")
  private Dog dog;
}
