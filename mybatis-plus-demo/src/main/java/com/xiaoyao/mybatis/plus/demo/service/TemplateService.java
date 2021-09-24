package com.xiaoyao.mybatis.plus.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyao.mybatis.plus.demo.entity.Template;
import com.xiaoyao.mybatis.plus.demo.request.QueryPageParam;
import com.xiaoyao.mybatis.plus.demo.response.QueryResult;

/**
 * @author yls
 * @ClassName TemplateService
 * @Description
 * @Date 2021/3/3 13:39
 * @Version 1.0
 */
public interface TemplateService extends IService<Template> {
  /**
   * 分布查询
   * @param param
   * @return
   */
  QueryResult<Template> queryTemplatePage(QueryPageParam param);
}
