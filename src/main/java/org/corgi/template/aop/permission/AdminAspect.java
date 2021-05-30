package org.corgi.template.aop.permission;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.corgi.template.annotation.permission.AdminRequired;
import org.corgi.template.exception.PermissionDeniedException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminAspect {

    @Pointcut(value = "@annotation(org.corgi.template.annotation.permission.AdminRequired)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut() && @annotation(annotation)")
    public void permissionCheck(JoinPoint joinPoint, AdminRequired annotation) {
        if (!validate()) {
            throw new PermissionDeniedException(annotation.message());
        }
    }

    private boolean validate() {
        return true;
    }
}

