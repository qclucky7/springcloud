package com.example.demo;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Static
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/10/15 16:17
 * @Version 1.0
 */
public class Static {

   static int sum = 20;
   static int sign = 0;


    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                try {
                    lock.lock();
                    while (sign != 0){
                        condition.await();
                    }
                    if (sum == 0 ){
                      return;
                    }
                    sum--;
                    System.out.println(Thread.currentThread().getName() + "-1" + "剩余->"+ sum);
                    sign = 1;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    condition1.signal();
                    lock.unlock();
                }
            },"A").start();
            new Thread(()->{
                try {
                    lock.lock();
                    while (sign != 1){
                        condition1.await();
                    }
                    if (sum == 0 ){
                        return;
                    }
                    sum--;
                    System.out.println(Thread.currentThread().getName() + "-1" + "剩余->"+ sum);
                    sign = 2;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    condition2.signal();
                    lock.unlock();
                }
            },"B").start();
            new Thread(()->{
                try {
                    lock.lock();
                    while (sign != 2){
                        condition2.await();
                    }
                    if (sum == 0 ){
                        return;
                    }
                    sum--;
                    System.out.println(Thread.currentThread().getName() + "-1" + "剩余->"+ sum);
                    sign = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    condition.signal();
                    lock.unlock();
                }
            },"C").start();
        }

        System.out.println(TimeUnit.SECONDS);

    }
}
