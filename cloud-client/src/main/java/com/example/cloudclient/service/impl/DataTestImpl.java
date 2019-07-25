package com.example.cloudclient.service.impl;

import com.example.cloudclient.model.User;
import com.example.cloudclient.service.DataTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName DataTestImpl
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/23 15:53
 * @Version 1.0
 */
@Service
public class DataTestImpl implements DataTest {

    private Logger logger = LoggerFactory.getLogger(DataTestImpl.class);

    int num = 0;

    @Override
    public List<User> getData() {

        User user = new User();

        user.setName("大菠萝")
            .setAge(new Long(18));

        ArrayList<User> users = new ArrayList<>();

        users.add(user);

        num = num +1;

        logger.info("数据库操作{}次",num);

       return users;
    }
}
