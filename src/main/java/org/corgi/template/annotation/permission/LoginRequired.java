package org.corgi.template.annotation.permission;

import java.lang.annotation.*;

/**
 * 登陆才可操作
 * 使用方法：Controller 上加此注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
    String message() default "您尚未登陆";
}