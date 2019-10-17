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

    @Pointcut("@annotation(com.example.demo.aspect.AnalysisTime)")
    public void analysisTimes(){

    }

    @Before("analysisTimes()")
    public void startTime(){
        System.out.println("执行前");
    }

    @After("analysisTimes()")
    public void endTime(){
        System.out.println("执行后");
    }
}
