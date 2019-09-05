package com.example.demo.designmodel.observer.observer;

import com.example.demo.designmodel.observer.Interface.Observer;
import com.example.demo.testbo.CommonBO;
import com.example.demo.testbo.Test1BO;


/**
 * @ClassName ObserverImpl
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 14:45
 * @Version 1.0
 */
public class Observer1 implements Observer {

    @Override
    public Test1BO update() {
        Test1BO test1BO = new Test1BO();
        test1BO.setId(1);
        test1BO.setName("test1");
        return test1BO;
    }
}
