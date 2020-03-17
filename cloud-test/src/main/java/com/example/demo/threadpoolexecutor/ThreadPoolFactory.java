package com.example.demo.threadpoolexecutor;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolExecutor
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/9/23 14:57
 * @Version 1.0
 */
@Component
public class ThreadPoolFactory{


    //自定义异常策略
    static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            new Thread(r,Thread.currentThread().getName()).start();
        }
    }

    //四种线程池拒绝策略
    //默认拒绝策略  //拒绝策略1：将抛出 RejectedExecutionException.
        //new ThreadPoolExecutor.AbortPolicy();
    //策略2：ThreadPoolExecutor.CallerRunsPolicy 用于被拒绝任务的处理程序，
    //它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
        //new ThreadPoolExecutor.CallerRunsPolicy();
    //什么也不干
        //new ThreadPoolExecutor.DiscardPolicy();
    //DiscardOldestPolicy策略的作用是，当任务被拒绝添加时，会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去
        //new ThreadPoolExecutor.DiscardOldestPolicy();
    //自定义异常策略
        //new CustomRejectedExecutionHandler();

    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            1,
            1,
            3,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static ThreadPoolExecutor getPoolExecutor(){
        return poolExecutor;
    }





    /*private static final int MAX_POOL = Runtime.getRuntime().availableProcessors();

    private static ExecutorService executor = Executors.newFixedThreadPool(MAX_POOL);

    @PreDestroy
    public void stop() {
        //停止线程池
        executor.shutdownNow();
        try {
            //检查线程池是否关闭!
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }

    static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return Thread.currentThread().getName();
        }
    }*/

    public static void main(String[] args) {


        //四种线程池拒绝策略
        //默认拒绝策略  //拒绝策略1：将抛出 RejectedExecutionException.
        new ThreadPoolExecutor.AbortPolicy();
        //策略2：ThreadPoolExecutor.CallerRunsPolicy 用于被拒绝任务的处理程序，
        //它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
        new ThreadPoolExecutor.CallerRunsPolicy();
        //什么也不干
        new ThreadPoolExecutor.DiscardPolicy();
        //DiscardOldestPolicy策略的作用是，当任务被拒绝添加时，会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去
        new ThreadPoolExecutor.DiscardOldestPolicy();
        //自定义异常策略
        new CustomRejectedExecutionHandler();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                Runtime.getRuntime().availableProcessors() + 1,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new CustomRejectedExecutionHandler()
        );


        CountDownLatch countDownLatch = new CountDownLatch(3);
        try {
            countDownLatch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        cyclicBarrier.getNumberWaiting();

        //ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        /*List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 5  ; i++) {
            Future<String> submit = ThreadPool.executor.submit(new Task());
            futures.add(submit);
        }

        futures.forEach(future->{
            try {
                System.out.println(future.get(2000,TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                future.cancel(true);
            }
        });*/

//        String[] a = {"1", "2", "3", "4"};
//
//        String s = String.join(",", a);
//        System.out.println(s);


        //ThreadPool threadPool = new ThreadPool();
        //String s = threadPool.test1();


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
