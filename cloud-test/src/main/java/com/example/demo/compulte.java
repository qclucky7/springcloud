package com.example.demo;

public interface compulte {

    default String test1(){

        return "123";
    }

   static long compulte(long number){

        return number+100;
    }
}
