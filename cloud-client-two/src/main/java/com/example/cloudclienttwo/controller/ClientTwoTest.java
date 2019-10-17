package com.example.cloudclienttwo.controller;


import com.example.cloudclienttwo.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName test
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:06
 * @Version 1.0
 */
@Slf4j
@RefreshScope
@RestController
public class ClientTwoTest {


    @GetMapping(value = "/getClient2Data")
    public Flux<Data> getData() {
        Data data = new Data();
        data.setId(567);
        data.setTime(10000);
        data.setData("返回成功");
        return Flux.just(data);
    }

    @GetMapping(value = "/getClient2Data2")
    public String getData2() {


        return "Client2Data2";
    }

    @PostMapping(value = "/postClient2Data")
    public Data postData(@RequestBody Data data){

        log.info("data = {}",data);

        return data;
    }

    @Value("${name1}")
    private String name;

    @RequestMapping(value = "/test", method = GET)
    public String test(){
        return name;
    }
}
