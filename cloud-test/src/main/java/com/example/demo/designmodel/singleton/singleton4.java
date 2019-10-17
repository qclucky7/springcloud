package com.example.demo.designmodel.singleton;

/**
 * @ClassName singleton4
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/26 15:52
 * @Version 1.0
 */
//枚举实现单例
public class singleton4 {

    private singleton4(){

    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton{
        INSTANCE;

        private final singleton4 instance;

        Singleton(){
            instance = new singleton4();
        }

        private singleton4 getInstance(){
            return instance;
        }
    }

    public static singleton4 getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

}
