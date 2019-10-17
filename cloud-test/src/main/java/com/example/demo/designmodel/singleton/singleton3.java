package com.example.demo.designmodel.singleton;

/**
 * @ClassName singleton3
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/26 15:51
 * @Version 1.0
 */
//匿名内部类
public class singleton3 {

    private singleton3(){

    }
    // 单例持有者
    private static class InstanceHolder{
        private  final static singleton3 instance = new singleton3();

    }

    //
    public static singleton3 getInstance(){
        // 调用内部类属性
        return InstanceHolder.instance;
    }
}
