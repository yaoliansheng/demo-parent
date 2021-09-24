package com.xiaoyao.mysq.linterceptor.demo.annotation;

import java.lang.annotation.*;

/**
 * @author yls
 * @ClassName SensitiveField
 * @Description 注解敏感信息类中敏感字段的注解
 * @Date 2021/4/15 19:50
 * @Version 1.0
 */
@Inherited
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveField {
}