package com.example.cloudclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName test
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:06
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/test1")
public class test {

    @GetMapping(value = "/test")
    public String getData(){

        return "client-data";
    }

    @GetMapping(value = "/test2")
    public String getData2(){

        return "client-data2";
    }


}
