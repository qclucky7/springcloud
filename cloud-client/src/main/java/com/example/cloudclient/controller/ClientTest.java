package com.example.cloudclient.controller;

import com.example.cloudclient.model.User;
import com.example.cloudclient.service.DataTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

        return userList;
    }

    @GetMapping(value = "/getData2")
    @CachePut(cacheNames = "user-List", key = "'userList'")
    public List<User> getData2() {

        num = num +1 ;

        List<User> data = dataTest.getData();

        data.stream().forEach(x->{
            x.setName("小菠萝"+num);
            x.setAge(new Long(19));
        });

        return data;
    }


}
