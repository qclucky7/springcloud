package com.example.demo.designmodel.observer.Interface;


import java.util.List;

/**
 * 抽象通知者
 */
public interface InFormer {

     void add(Observer observer);
     void delete(Observer observer);
     List<Object> change();
}
