package com.example.springcloud;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName Animal
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/13 15:52
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Animal extends User{

    private String name;
    private int age;
    private String place;
}
