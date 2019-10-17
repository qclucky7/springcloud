package com.example.demo.threadpoolexecutor;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolExecutor
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/23 14:57
 * @Version 1.0
 */
public class ThreadPool implements test{

    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool();
        String s = threadPool.test1();


        /*ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                4,    // 核心线程数
                10, // 最大线程数
                0,  // 生存时间
                TimeUnit.MILLISECONDS,       // keepAliveTime值的度量单位
                new LinkedBlockingQueue<Runnable>());// 阻塞队列

        for (int i = 0; i < 50; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 执行 - ");
                    System.out.println(poolExecutor.getQueue().size());
                    System.out.println("run");
                }
            });
        }*/



       /* ThreadPoolExecutor pool =
                new ThreadPoolExecutor(
                        4,
                        10,
                        0,
                        TimeUnit.MILLISECONDS,
                        new SynchronousQueue<>(),
                        new ThreadPoolExecutor.CallerRunsPolicy());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " 执行 - " + i);
                }
                System.out.println("run");
            }
        });
*/

    }


}
