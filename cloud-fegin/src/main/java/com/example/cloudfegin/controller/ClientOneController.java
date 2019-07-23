package com.example.cloudfegin.controller;

import com.example.cloudfegin.fallback.HystrixClientOneService;
import com.example.cloudfegin.feginclient.ClientOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName controller
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:26
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/client1")
public class ClientOneController {


    @Autowired
    private ClientOneService clientOneService;

    @GetMapping(value = "/getData")
    public String test(){

        return clientOneService.getData();
    }

    @GetMapping(value = "/getData2")
    public String test2(){

        return clientOneService.getData2();
    }
}
