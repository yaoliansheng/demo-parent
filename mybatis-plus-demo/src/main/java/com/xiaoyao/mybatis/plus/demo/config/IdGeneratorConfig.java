/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：sail_wxovertake
 * 文件名：WxovertakeConfig
 * 模块说明：
 * 修改历史：
 * 2020/4/7 - zhaolingling - 创建
 */
package com.xiaoyao.mybatis.plus.demo.config;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;

@Configuration
public class IdGeneratorConfig {
  @Value("${server.workerId:1}")
  private Long workerId;

  @Bean
  @Primary
  public IdGenerator getIdGenerator() {
    if (workerId < 1){
      Random random = new Random();
      int id = random.nextInt(1023);
      workerId = Long.valueOf(id);
    }
    CommonSelfIdGenerator.setWorkerId(workerId);
    CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
    return commonSelfIdGenerator;
  }
}
