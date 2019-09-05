package com.example.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * @ClassName AnalysisTime
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/27 10:24
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class AnalysisTimes {

    @Pointcut(value = "@annotation(com.example.demo.aspect.AnalysisTime)")
    public void analysisTimes(){

    }

    @Before("analysisTimes()")
    public void startTime(JoinPoint joinPoint){
        System.out.println(1111);
        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);
        String name = joinPoint.getTarget().getClass().getName();
        log.info("{}方法开始时间{}",name,millis);

    }

    @After("analysisTimes()")
    public void endTime(JoinPoint joinPoint){

        long millis = Clock.systemDefaultZone().millis();
        String name = joinPoint.getTarget().getClass().getName();
        log.info("{}方法结束时间{}",name,millis);
    }
}
