package com.example.demo.test;

import com.example.demo.aspect.AnalysisTime;

/**
 * @ClassName TestAspectJ
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 9:13
 * @Version 1.0
 */
public class TestAspectJ {

    @AnalysisTime
    public static void test(){
        System.out.println("测试切面");
    }

}
