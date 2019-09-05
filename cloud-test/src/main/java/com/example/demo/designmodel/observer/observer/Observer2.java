package com.example.demo.designmodel.observer.observer;

import com.example.demo.designmodel.observer.Interface.Observer;
import com.example.demo.testbo.CommonBO;
import com.example.demo.testbo.Test2BO;

/**
 * @ClassName Observer2
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 15:10
 * @Version 1.0
 */
public class Observer2 implements Observer {

    @Override
    public Test2BO update() {
        Test2BO test2BO = new Test2BO();
        test2BO.setId(2);
        test2BO.setName("test2");
        test2BO.setType(2);
        return test2BO;
    }
}
