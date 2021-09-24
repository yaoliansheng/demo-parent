package com.xiaoyao.multiple.datasources.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@MapperScan(basePackages = "com.xiaoyao.multiple.datasources.demo.mapper.two", sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class DbTwoConfig {

  @Bean(name = "twoDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.druid.two")
  public DataSource druidDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "twoSqlSessionFactory")
  @Primary
  public SqlSessionFactory sqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean  = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    //分页插件
    Properties properties = new Properties();
    properties.put("reasonable", "false");
    properties.put("pageSizeZero", "true");
    PageInterceptor pageInterceptor = new PageInterceptor();
    pageInterceptor.setProperties(properties);
    bean.setPlugins(new Interceptor[]{pageInterceptor});
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/two/*.xml"));
    return bean.getObject();
  }

  @Bean(name = "twoSqlSessionTemplate")
  @Primary
  public SqlSessionTemplate sqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean(name = "twoTransactionManager")
  @Primary
  public DataSourceTransactionManager transactionManager(@Qualifier("twoDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
