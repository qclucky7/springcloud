package com.example.demo;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.apache.http.client.config.RequestConfig;

import javax.swing.text.Document;
import javax.xml.soap.Node;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName common
 * @Author wangchen
 * @Date 2019/10/18 16:04
 * @Version 1.0
 */
public class common {

    private static final Map<Integer,String> cacheMap = new ConcurrentHashMap<>();

   static {
        cacheMap.put(1,"1");
        cacheMap.put(2,"2");
        cacheMap.put(3,"3");
    }

    public static String get(int key){
        if (cacheMap.isEmpty()){
            cacheMap.put(1,"1");
            cacheMap.put(2,"2");
            cacheMap.put(3,"3");
            cacheMap.put(4,"4");
            return "456";
        }
        return cacheMap.getOrDefault(key,"空");
    }

    //底层建造者模式
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(1)
            .setConnectTimeout(1)
            .setSocketTimeout(1)
            .build();


    /**
     * 本月开始时间戳
     * @param nowTime
     * @return
     * @throws
     */
    public static long getMonthEndTime(long nowTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(nowTime);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        long endTime = calendar.getTimeInMillis();
        return endTime;
    }

    static class test{

        private long l;
        private long z;

        public long getL() {
            return l;
        }

        public void setL(long l) {
            this.l = l;
        }

        public long getZ() {
            return z;
        }

        public void setZ(long z) {
            this.z = z;
        }

        @Override
        public String toString() {
            return "test{" +
                    "l=" + l +
                    ", z=" + z +
                    '}';
        }
    }

    public static int getDaysOfMonth(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


    }

    public static boolean isWeekend(long time) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            return true;
        } else{
            return false;
        }

    }


    public static boolean isLastDayOfMonth(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 本周结束时间戳 周日算
     * @param nowTime
     * @return
     * @throws
     */
    public static long getWeekEndTime(long nowTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(nowTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        if (calendar.get(Calendar.DAY_OF_WEEK) != 1) {
            calendar.set(Calendar.DAY_OF_WEEK, 7);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        long endTime = calendar.getTimeInMillis();
        return endTime;
    }


    public static final int [] PERSONAL_FLOWER_THIRD = {1,5};


    public static void test(int... ints){
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //按每75个动态一组去批处理吧
    private static final int MAX_NUMBER = 75;

    /**
     * 计算切分次数
     */
    private static int countStep(int size) {
        return (size + MAX_NUMBER - 1) / MAX_NUMBER;
    }


    public static void main(String[] args) {

     /*   List<Long> list = Arrays.asList(1L,2L,3L,4L);

        List<List<Long>> dynamicTasks = Stream.iterate(0, n -> n + 1)
                .limit(common.countStep(list.size()))
                .map(a -> list.stream()
                        .skip(a * MAX_NUMBER)
                        .limit(MAX_NUMBER)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());*/

        /* ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
         scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(cacheMap.values()),0,1, TimeUnit.SECONDS);

        for (int i = 0; i < 5 ; i++) {
            System.out.println(get(i));
        }*/

       /* System.out.println(getMonthEndTime(System.currentTimeMillis()));

        System.out.println(MedalBaseEnum.Habit.time_type_10.getDays());
        System.out.println(MedalBaseEnum.Habit.time_type_10.getHabitSpecificDetail());*/

       /* List<String> l = Arrays.asList("98%","90%");


        //Collections.sort(l, Comparator.comparing(v -> Integer.valueOf(v.replaceAll("%", "")),Comparator.reverseOrder()));


        System.out.println(l.toString());*/

        /*int i = 4;

        int j = 23;

        double round = Math.round(i / j);

        System.out.println(round);


        test test = new test();
        test.setL(1);
        test.setZ(1);
        test test1 = new test();
        test1.setL(2);
        test1.setL(2);

        List<test> l = new ArrayList<>();

        l.add(test);
        l.add(test1);

        l.stream().filter(test2 -> test2.getL() == 1).peek(test2 -> test2.setZ(55555));

        System.out.println(l.toString());*/

/*
        System.out.println(getDaysOfMonth(1575129600000L-1));

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");

        long a = 1576198650000L;

        System.out.println(simpleFormatter.format(0));*/

        /*System.out.println(isWeekend(1576339200000L));


        System.out.println(isLastDayOfMonth(1577721600000L));


        System.out.println(getWeekEndTime(1577721600000L));


        String m = "every_pdp_type";
        String habitSpecificDetail = MedalBaseEnum.Pdp.time_type_1.getPdpSpecificDetail();

        System.out.println(m.equals(habitSpecificDetail));*/

        /*double floor = Math.floor(
                (double) 999
                        /
                        1000
                        * 100);

        long floor1 = (long)Math.floor(
                (double) 989
                        /
                        1000
                        * 100);
        System.out.println(floor);
        System.out.println(floor1);*/


       /* //实例化PdfDocument类的对象，并加载测试文档
        PdfDocument doc = new PdfDocument();

        doc.loadFromFile("E://2.pdf");

        //获取文档第1页
        PdfPageBase page = doc.getPages().get(0);

        //加载图片，设置为背景水印
        page.setBackgroundImage("E://pdp.png");

        //指定水印在文档中的位置及图片大小
        Rectangle2D.Float rect = new Rectangle2D.Float();
        rect.setRect(200, 605, 605, 220);
        page.setBackgroundRegion(rect);

        //保存文档
        doc.saveToFile("E://imageWaterMark.pdf");
        doc.close();*/

       /* List<MyException.User> list1 = Arrays.asList(
                null,null
        );

         List<MyException.User> collect = list1.stream()
                 .filter(user -> 1 == Optional.ofNullable(user)
                 .orElse(new MyException.User()).getId()).collect(Collectors.toList());

        List<MyException.User> collect1 = list1.stream()
                .filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(collect1.toString());*/

        LRUCache<String, String> cache = new LRUCache<>();

        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","3");
        cache.put("4","4");
        cache.put("5","5");
        cache.put("6","6");


        String path = "F:\\test";


        System.out.println(cache.toString());

        final Object o = Optional.ofNullable(null).orElse("123");

        System.out.println(o);

        final boolean mkdir = new File(path).mkdir();


        CompletableFuture[] completableFutures = Stream.of(1, 1, 3, 4, 5).map(x -> CompletableFuture.supplyAsync(() -> {
            File file = new File(path + File.separator + x);
            if (file.exists()){
                System.out.println("存在路径");
            } else {
                System.out.println("不存在路径");
            }
            file.mkdir();
            return false;
        })).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();

        System.out.println(UUID.randomUUID().toString());


    }
}
