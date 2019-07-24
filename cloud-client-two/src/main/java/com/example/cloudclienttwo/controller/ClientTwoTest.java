package com.example.cloudclienttwo.controller;

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
@RequestMapping(value = "/client2")
public class ClientTwoTest {

    @GetMapping(value = "/getClient2Data")
    public String getData(){

        return "client2-data";
    }

    @GetMapping(value = "/getClient2Data2")
    public String getData2(){

        return "client2-data2";
    }


}
