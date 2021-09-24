package com.xiaoyao.mybatis.plus.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaoyao.mybatis.plus.demo"})
@MapperScan(value = {"com.xiaoyao.mybatis.plus.demo.mapper"})
public class MybatisPlusDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusDemoApplication.class, args);
  }

}
