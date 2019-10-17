package com.example.demo.test;

import com.example.demo.aspect.AnalysisTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestAspectJ
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 9:13
 * @Version 1.0
 */
@RestController
public class TestAspectJ {

    @AnalysisTime
    @RequestMapping(value = "/test")
    public static void test(){
        System.out.println("测试切面");
    }

    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 127;

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


}
