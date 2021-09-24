package com.xiaoyao.mybatis.plus.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyao.mybatis.plus.demo.entity.Template;
import com.xiaoyao.mybatis.plus.demo.mapper.TemplateMapper;
import com.xiaoyao.mybatis.plus.demo.request.QueryPageParam;
import com.xiaoyao.mybatis.plus.demo.response.QueryResult;
import com.xiaoyao.mybatis.plus.demo.service.TemplateService;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template>
    implements TemplateService {
  
  @Override
  public QueryResult<Template> queryTemplatePage(QueryPageParam param) {
    QueryResult<Template> queryResult = new QueryResult<>();
    Page<Template> templatePage = new Page<>(param.getPageIndex(), param.getPageSize(), true);
    LambdaQueryWrapper<Template> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(Template::getRemark,"xxxx");
    //TODO 条件
    baseMapper.selectPage(templatePage, wrapper);
    queryResult.setPageIndex(templatePage.getCurrent());
    queryResult.setPageSize(templatePage.getSize());
    queryResult.setTotalCount(templatePage.getTotal());
    queryResult.setRecords(templatePage.getRecords());
    return queryResult;
  }
}