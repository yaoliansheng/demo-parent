package com.xiaoyao.multiple.datasources.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
  @Bean
  public Docket createRestApi() {
    ApiInfo apiInfo =
        new ApiInfoBuilder()
            .title("系统API")
            .description("采用SpringBoot开发，API文档集成Swagger")
            .version("1.0")
            .contact(new Contact("连胜", "https://github.com", "441293331@qq.com"))
            .license("我的首页")
            .licenseUrl("........")
            .build();
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.xiaoyao.multiple.datasources.demo"))
        .paths(PathSelectors.any())
        .build();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.
            addResourceHandler( "/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
            .resourceChain(false);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController( "/swagger-ui/")
            .setViewName("forward:" +  "/swagger-ui/index.html");
  }
}

