package com.xiaoyao.mysq.linterceptor.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yls
 * @ClassName AddMemberParam
 * @Description
 * @Date 2021/4/15 14:01
 * @Version 1.0
 */
@Data
public class AddMemberParam {
  @ApiModelProperty("姓名")
  private String name;
  @ApiModelProperty("年龄")
  private Integer age;
  @ApiModelProperty("手机号码")
  private String mobile;
}
