package com.xiaoyao.mybatis.plus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyao.mybatis.plus.demo.entity.Template;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yls
 * @ClassName TemplateMapper
 * @Description
 * @Date 2021/4/16 17:10
 * @Version 1.0
 */
@Mapper
public interface TemplateMapper  extends BaseMapper<Template> {
}
