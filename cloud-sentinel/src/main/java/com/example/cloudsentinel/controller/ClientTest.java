package com.example.cloudsentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName test
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:06
 * @Version 1.0
 */

@RestController
public class ClientTest {


    @GetMapping(value = "/1")
    @SentinelResource("getData")
    public String getData() {


        return "123";
    }


}
