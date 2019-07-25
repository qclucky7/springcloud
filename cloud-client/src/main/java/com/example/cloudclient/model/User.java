package com.example.cloudclient.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName User
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/23 16:31
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private String name;

    private Long age;

}
