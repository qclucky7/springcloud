package com.example.demo.designmodel.singleton;

/**
 * @ClassName singleton2
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/26 15:39
 * @Version 1.0
 */
//双重检查锁
public class singleton2 {

    private static volatile singleton2 instance;

    private singleton2(){

    }

    public static singleton2 getInstance(){

        if (instance == null)
            synchronized (singleton2.class){
                if (instance == null){
                    instance = new singleton2();
                }
            }

        return instance;
    }

}
