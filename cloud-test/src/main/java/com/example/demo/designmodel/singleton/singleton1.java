package com.example.demo.designmodel.singleton;

/**
 * @ClassName singleton1
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/26 15:38
 * @Version 1.0
 */
//懒汉式
public class singleton1 {

    // 定义静态变量时，未初始化实例
    private static singleton1 instance;

    // 私有化构造函数
    private singleton1(){

    }

    public synchronized static singleton1 getInstance(){
        // 使用时，先判断实例是否为空，如果实例为空，则实例化对象
        if (instance == null)
            instance = new singleton1();
        return instance;
    }
}
