package com.example.demo.threadpoolexecutor;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/9 13:54
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;

    private int age;

    private String job;

}
