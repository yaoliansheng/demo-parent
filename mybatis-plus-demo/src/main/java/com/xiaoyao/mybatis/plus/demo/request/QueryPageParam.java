/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：sail_onlineshop
 * 文件名：QueryPageParam
 * 模块说明：
 * 修改历史：
 * 2017-08-08 - suizhe - 创建
 */
package com.xiaoyao.mybatis.plus.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页查询参数
 *
 * @author yls
 */
@Data
public class QueryPageParam {
  @ApiModelProperty(value = "每页条数，默认10条")
  private int pageSize = 10;

  @ApiModelProperty(value = "分页，页码从1开始")
  private int pageIndex = 1;
}
