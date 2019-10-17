package com.example.demo.designmodel.singleton;

/**
 * @ClassName singleton
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/26 15:36
 * @Version 1.0
 */

//饿汉式
public class singleton {

    // 利用静态变量来存储唯一实例
    private static final singleton instance = new singleton();

    // 私有化构造函数
    private singleton(){
        // 里面可能有很多操作
    }
    // 提供公开获取实例接口
    public static singleton getInstance(){
        return instance;
    }

}
