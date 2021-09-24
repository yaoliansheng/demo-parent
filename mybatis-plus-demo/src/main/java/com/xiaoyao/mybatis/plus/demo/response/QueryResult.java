/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：sail-onlineshop
 * 文件名：QueryResult
 * 模块说明：
 * 修改历史：
 * 2020/3/30 - zhaolingling - 创建
 */
package com.xiaoyao.mybatis.plus.demo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryResult<T> {
  @ApiModelProperty(value = "记录数")
  private long totalCount;
  @ApiModelProperty(value = "当前页")
  private long pageIndex;
  @ApiModelProperty(value = "页记录数")
  private long pageSize;
  @ApiModelProperty(value = "记录列表")
  private List<T> records = new ArrayList<>();
}
