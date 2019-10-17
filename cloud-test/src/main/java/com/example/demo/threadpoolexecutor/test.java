package com.example.demo.threadpoolexecutor;

public interface test {

    default String test1(){

        return "123";
    }

    static String test2(){

        return "123";
    }
}
