package com.xiaoyao.mapstruct.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan(value = {"com.xiaoyao.mapstruct.demo.mapper"})
public class MapstructDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MapstructDemoApplication.class, args);
  }

}
