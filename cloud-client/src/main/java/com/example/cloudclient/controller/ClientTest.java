package com.example.cloudclient.controller;

import com.example.cloudclient.model.User;
import com.example.cloudclient.service.DataTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName test
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/12 16:06
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping(value = "/client1")
public class ClientTest {

    int num = 0;

    @Autowired
    private DataTest dataTest;

    @GetMapping(value = "/getData")
    @Cacheable(cacheNames = "user-List", key = "'userList'")
    public List<User> getData() {

        List<User> userList = dataTest.getData();

        if (userList == null) {
            log.info("userList is null");
        }

        return userList;
    }

    @GetMapping(value = "/getData2")
    @CachePut(cacheNames = "user-List", key = "'userList'")
    public List<User> getData2() {

        num = num + 1;

        List<User> data = dataTest.getData();

        if (data != null) {
            data.stream().forEach(x -> {
                x.setName("小菠萝" + num)
                 .setAge(new Long(19));
            });
        } else {
            log.info("data is null");
        }

        return data;
    }


}
