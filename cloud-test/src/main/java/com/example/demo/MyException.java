package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.threadpoolexecutor.ErrorCode;
import com.example.demo.threadpoolexecutor.ThreadPoolFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import sun.security.provider.MD5;
import sun.security.provider.SecureRandom;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName MyException
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/11/25 16:44
 */
@Slf4j
public class MyException extends Exception {

    private static final long serialVersionUID = 1779571984263011273L;
    private ErrorCode code;
    private String errorData;

    public MyException(ErrorCode code, Throwable t) {
        super(code.name(), t);
        this.code = code;
    }

    public MyException(ErrorCode code, Throwable t, String errorData) {
        super(code.name(), t);
        this.code = code;
        this.errorData = errorData;
    }

    public ErrorCode getCode() {
        return code;
    }

    public String getErrorData() {
        return errorData;
    }

    /**
     * 本日开始时间戳
     *
     * @param nowTime
     * @return
     * @throws
     */
    public static long getTodayBeginTime(long nowTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(nowTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long beginTime = calendar.getTimeInMillis();
        return beginTime;
    }

    private static String l() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123";
    }

    @Data
    static class User{

        private long id;

        private String name;

    }

    private static final List<String> list = new CopyOnWriteArrayList<>();

    //private static final List<String> list = new LinkedList<>();

    private static final Map<String, String> cacheMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        /*List<String> list1 = new ArrayList<>();

        long l1 = System.currentTimeMillis();
        ArrayList<Boolean> collect = Stream.iterate(0, i -> i + 1).limit(5).map(x -> {
            System.out.println(Thread.currentThread().getName());
            String l = MyException.l();
            return list1.add(l);
        }).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(list1.toString());
        System.out.println("time = " + (System.currentTimeMillis() - l1));*/

        /*long l2 = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        CompletableFuture[] completableFutures = Stream.iterate(0, i -> i + 1).limit(5)
                .map(x -> CompletableFuture.supplyAsync(()->{
                    System.out.println(Thread.currentThread().getName());
                    //long i  = 10/0;
                    return MyException.l();
                }).thenApply(list::add)
                .exceptionally(ex -> {
                    System.out.println("error = " + ex.getMessage());
                    return false;
                }))
                .toArray(CompletableFuture[]::new);


        CompletableFuture.allOf(completableFutures).join();

        System.out.println(list.toString());
        System.out.println("time = " + (System.currentTimeMillis() - l2));
        System.out.println("5555555");*/


        /*final User user = new User();
        user.setId(1);
        user.setName("456");
        String s = JSONObject.toJSONString(user);

        System.out.println(s);

        User user1 = JSONObject.parseObject(s, User.class);
        System.out.println(user1);


        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        List<String> list1 = Arrays.asList("6", "7", "8", "9", "10");

        List<String> list2 = Arrays.asList("12", "13", "14", "15", "16");

        List<List<String>> lists = new ArrayList<>();

        lists.add(list);
        lists.add(list1);
        lists.add(list2);

        List<List<CompletableFuture<String>>> collect = lists.stream()
                .map(m -> m.stream().map(y -> CompletableFuture.supplyAsync(() -> {

                            System.out.println(Thread.currentThread().getName());
                            return y;

                          }
                        )).collect(Collectors.toList())
        ).collect(Collectors.toList());


        List<String> collect1 = lists.stream()
                .flatMap(strings -> strings.stream())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect1);

        final SecureRandom secureRandom = new SecureRandom();*/

       /* ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2, new NamedThreadFactory("test",false));



        scheduledThreadPool.scheduleAtFixedRate(()-> {
            System.out.println();
        },0,1,TimeUnit.SECONDS);*/


      /* CompletableFuture[] completableFutures = Stream.iterate(0, n -> n + 1).limit(100).map(n -> CompletableFuture.supplyAsync(() -> {
                    list.add("test" + n);
                    return true;
                },ThreadPoolFactory.getPoolExecutor()).thenCompose(CompletableFuture::completedFuture)
               .exceptionally(ex -> {
                   System.out.println(ex.getMessage());
                   return null;
               })
        ).toArray(CompletableFuture[]::new);


        CompletableFuture[] completableFutures1 = Stream.iterate(0, n -> n + 1).limit(50).map(n -> CompletableFuture.supplyAsync(() -> {
                    list.remove("test" + n);
                    return true;
                },ThreadPoolFactory.getPoolExecutor()).thenCompose(CompletableFuture::completedFuture)
                .exceptionally(ex -> {
                       System.out.println(ex.getMessage());
                       return null;
                }
                )
        ).toArray(CompletableFuture[]::new);


        System.out.println(completableFutures.length);

        System.out.println(completableFutures.length);



       CompletableFuture.allOf(completableFutures).join();
       CompletableFuture.allOf(completableFutures1).join();


        ThreadPoolFactory.getPoolExecutor().getActiveCount();
        ThreadPoolFactory.getPoolExecutor().getTaskCount();*/


        System.out.println(Runtime.getRuntime().availableProcessors());




    }

}
