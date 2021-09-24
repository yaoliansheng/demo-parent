package com.xiaoyao.mysq.linterceptor.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan(value = {"com.xiaoyao.mysq.linterceptor.demo"})
public class MysqlInterceptorDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MysqlInterceptorDemoApplication.class, args);
  }

}
