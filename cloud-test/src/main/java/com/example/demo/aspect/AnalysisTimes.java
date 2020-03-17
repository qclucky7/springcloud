package com.example.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.acl.LastOwnerException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName AnalysisTime
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/27 10:24
 * @Version 1.0
 */
@Aspect
@Slf4j
public class AnalysisTimes extends AbstractSentinelAspectSupport{

    @Pointcut("@annotation(com.example.demo.aspect.AnalysisTime)")
    public void analysisTimes(){

    }


    @Around("analysisTimes()")
    public void analysisTimes(ProceedingJoinPoint pjp) throws Throwable {

        AnalysisTime annotation = pjp.getTarget().getClass().getAnnotation(AnalysisTime.class);
        TimeType type = annotation.type();
        System.out.println(type.toString());
        pjp.proceed();
    }




}
