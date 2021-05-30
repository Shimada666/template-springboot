package org.corgi.template.annotation.permission;

import java.lang.annotation.*;

/**
 * 系统管理员权限注解，只有系统管理员才可操作
 * 使用方法：Controller 上加此注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminRequired {
    String message() default "非系统管理员";
}