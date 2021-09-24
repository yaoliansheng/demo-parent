package com.xiaoyao.mybatis.plus.demo.controller;

import com.xiaoyao.mybatis.plus.demo.entity.Template;
import com.xiaoyao.mybatis.plus.demo.request.QueryPageParam;
import com.xiaoyao.mybatis.plus.demo.response.QueryResult;
import com.xiaoyao.mybatis.plus.demo.service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yls
 * @ClassName DemoController
 * @Description
 * @Date 2021/4/16 16:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "测试")
public class DemoController {

  @Autowired
  private TemplateService templateService;

  @PostMapping("/query")
  @ApiOperation("查询")
  public QueryResult<Template> query(@RequestBody QueryPageParam param){
    return templateService.queryTemplatePage(param);
  }
}
