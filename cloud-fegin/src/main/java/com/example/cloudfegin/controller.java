package com.example.cloudfegin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName controller
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:26
 * @Version 1.0
 */
@RestController
public class controller {

    @Autowired
    private service service;

    @GetMapping(value = "/test")
    public String test(){

        return service.test();
    }

    @GetMapping(value = "/test2")
    public String test2(){

        return service.test2();
    }
}
