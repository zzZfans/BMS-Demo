package com.zfans.bmsdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author Zfans
 * @DateTime 2021/6/17 14:16
 */
@Aspect
@Component
@Slf4j
public class ServiceMethodExecuteTimeLogger {

    /**
     * 统计方法执行耗时，并打印出入参数
     * 匹配 com.zfans.bmsdemo.service.impl 包下的全部方法
     * logExample: Class: com.zfans.bmsdemo.service.impl.CategoryServiceImpl Method: com.zfans.bmsdemo.util.page.PageResult selectOfPage(int,int) 执行时间：290 ms
     *
     * @param joinPoint
     * @return ret
     */
    @Around("execution (public * com.zfans.bmsdemo.service.impl.*.*(..))")
    public Object timeAround(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        String returnTypeName = signature.getReturnType().getTypeName();
        String parameterTypes = Arrays
                .stream(signature.getParameterTypes())
                .map(Class::getName)
                .collect(Collectors.joining(","));

        String detailedMethod = "Class: " + className +
                " Method: " + returnTypeName + " " + methodName +
                "(" + parameterTypes + ")";

        Object ret = null;
        Object[] args = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();
        try {
            ret = joinPoint.proceed(args);
        } catch (Throwable e) {
            log.error(detailedMethod + " 执行出错", e);
        }
        long endTime = System.currentTimeMillis();

        log.info(detailedMethod + " 执行时间：" + (endTime - startTime) + " ms");

        return ret;
    }
}
