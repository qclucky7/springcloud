package com.example.cloudfegin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.cloudfegin.BlockHander;
import com.example.cloudfegin.feginclient.ClientTwoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/client")
public class ClientTwoController {

    @Autowired
    private ClientTwoService clientTwoService;


    @GetMapping(value = "/getData")
    public String test(){

        return clientTwoService.getData();
    }

    @GetMapping(value = "/getData2")
    @SentinelResource(blockHandlerClass = BlockHander.class)
    public String test2(){

        return clientTwoService.getData2();
    }
}
