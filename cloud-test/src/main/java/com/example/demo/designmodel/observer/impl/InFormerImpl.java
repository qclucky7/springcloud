package com.example.demo.designmodel.observer.impl;

import com.example.demo.designmodel.observer.Interface.InFormer;
import com.example.demo.designmodel.observer.Interface.Observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName InFormerimpl
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 14:36
 * @Version 1.0
 */
public class InFormerImpl implements InFormer {

    private List<Observer> observers = new ArrayList<>();

    private List<Object> observer = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public List<Object> change() {
        observers.forEach(x->{
            observer.add(x.update());
        });
        return observer;
    }

}
