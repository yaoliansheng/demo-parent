package com.xiaoyao.mysq.linterceptor.demo.annotation;

import java.lang.annotation.*;

/**
 * @author yls
 * @ClassName SensitiveData
 * @Description 注解敏感信息类的注解
 * @Date 2021/4/15 19:48
 * @Version 1.0
 */
@Inherited
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveData {
}