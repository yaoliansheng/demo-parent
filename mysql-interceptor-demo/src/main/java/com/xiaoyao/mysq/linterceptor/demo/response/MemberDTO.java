package com.xiaoyao.mysq.linterceptor.demo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yls
 * @ClassName MemberDTO
 * @Description
 * @Date 2021/4/15 11:59
 * @Version 1.0
 */
@Data
public class MemberDTO {
  @ApiModelProperty("主键ID")
  private String id;
  @ApiModelProperty("姓名")
  private String name;
  @ApiModelProperty("年龄")
  private Integer age;
  @ApiModelProperty("手机号码")
  private String mobile;
}
