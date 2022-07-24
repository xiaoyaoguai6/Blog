package com.liu.blog2.common.aop;

import java.lang.annotation.*;

/**
 * 日志注解
 * @author lwz18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operation() default "";
}
