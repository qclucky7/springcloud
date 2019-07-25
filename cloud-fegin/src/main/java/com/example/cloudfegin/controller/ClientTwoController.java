package com.example.cloudfegin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.cloudfegin.BlockHander;
import com.example.cloudfegin.feginclient.ClientTwoService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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
    public String test2(){

        log.info("测试@Slf4j");
        return clientTwoService.getData2();
    }
}
