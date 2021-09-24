/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名: business-middle-badge
 * 文件名: MybatisPlusConfig
 * 模块说明：
 * 修改历史：
 * 2020/11/30  - panning - 创建。
 */
package com.xiaoyao.mybatis.plus.demo.config;

/**
 * @author yls
 *
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

  /**
   * mybatis-plus分页插件
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor page = new PaginationInterceptor();
    //方言
    page.setDialectType("mysql");
    //默认每页最多500条，这里改为10000条
    page.setLimit(10000L);
    return page;
  }
}