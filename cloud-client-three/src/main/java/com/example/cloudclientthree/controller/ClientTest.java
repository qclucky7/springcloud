package com.example.cloudclientthree.controller;

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
@RequestMapping(value = "/client1")
public class ClientTest {

    @GetMapping(value = "/getData")
    public String getData(){

        return "client3-data";
    }

    @GetMapping(value = "/getData2")
    public String getData2(){

        return "client3-data2";
    }


}
