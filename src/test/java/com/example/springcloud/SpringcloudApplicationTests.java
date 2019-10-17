package com.example.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudApplicationTests {

    @Test
    public void contextLoads() {

        User user = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        user.setName("蔡徐坤").setAge(18).setJob("篮球");
        user1.setName("鸡你太美").setAge(20).setJob("篮球");
        user2.setName("张继科").setAge(22).setJob("乒乓球");
        user3.setName("周杰伦").setAge(25).setJob("歌手");
        user4.setName("陈亮").setAge(28).setJob("歌手");
        user5.setName("陈亮").setAge(28).setJob("歌手");

        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);
        userArrayList.add(user4);
        userArrayList.add(user5);
        Animal animal = new Animal().setAge(1000).setName("乌龟").setPlace("中国");
        Animal animal1 = new Animal().setAge(50).setName("狗子").setPlace("家");
        ArrayList<Animal> list = new ArrayList<>();
        list.add(animal);
        list.add(animal1);

        Map<Integer, ArrayList<Animal>> integerArrayListMap1 = test.groupingByAge(list);
        log.info("animal--->{}", integerArrayListMap1);

        Map<String, List<User>> collect = userArrayList.stream().collect(Collectors.groupingBy(User::getJob));
        int max = userArrayList.stream().filter(x -> x.getAge() > 22).mapToInt(User::getAge).reduce(0, Integer::sum);
        OptionalInt max1 = userArrayList.stream().filter(x -> x.getAge() > 22).mapToInt(User::getAge).reduce(Integer::max);
        String collect1 = userArrayList.stream().map(User::getName).collect(Collectors.joining(",", "{", "}"));

        Optional<User> first1 = userArrayList.stream().filter(x -> x.equals(user5)).findFirst();
        User user6 = first1.get();
        log.info("first1->{}",user6);

        Map<String, List<User>> collect2 = userArrayList.stream().filter(x -> x.getAge() > 20).sorted(Comparator.comparing(User::getAge)).collect(Collectors.groupingBy(User::getJob));
        Map<Boolean, List<String>> collect3 = userArrayList.parallelStream()
                .distinct()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.partitioningBy(x -> x.getAge() > 20, Collectors.mapping(User::getName, Collectors.toCollection(ArrayList::new))));
        HashMap<Integer, List<User>> collect4 = userArrayList.parallelStream()
                .sorted(Comparator.comparing(User::getAge).reversed().thenComparing(User::getJob))
                .collect(Collectors.groupingBy(User::getAge, HashMap::new, Collectors.toCollection(ArrayList::new)));

        HashMap<Integer, List<String>> collect9 = userArrayList.parallelStream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.groupingBy(User::getAge, HashMap::new, Collectors.mapping(User::getName, Collectors.toList())));

        Map<String, IntSummaryStatistics> collect6 = userArrayList.stream().collect(Collectors.groupingBy(User::getJob, Collectors.summarizingInt(User::getAge)));
        //按工作分组，年龄总和为分组的值
        Map<String, Integer> collect7 = userArrayList.stream().collect(Collectors.groupingBy(User::getJob, Collectors.summingInt(User::getAge)));
        //按工作分组，人数总和为分组的值
        Map<String, Long> collect8 = userArrayList.stream().collect(Collectors.groupingBy(User::getJob, HashMap::new, Collectors.counting()));

        boolean b = userArrayList.stream().anyMatch(x -> x.getAge() == 18 && x.getName().equals("蔡徐坤"));

        Optional<User> max3 = userArrayList.stream().max(Comparator.comparing(User::getAge));

        Double collect5 = userArrayList.stream().collect(Collectors.averagingInt(User::getAge));

        new ConcurrentHashMap<>();

        User first = test.findFirst(userArrayList);
        long count1 = test.getCount(userArrayList);
        Map<Integer, ArrayList<User>> integerArrayListMap = test.groupingByAge(userArrayList);

        int i = Runtime.getRuntime().availableProcessors();
        //这些反映的是java虚拟机内存的情况。
        long l1 = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        //这个方法返回的是java虚拟机现在已经从操作系统那里挖过来的内存大小，也就是java虚拟机这个进程当时所占用的所有内存。如果在运行java的时候没有添加-Xms参数，那么，在java程序运行的过程的，内存总是慢慢的从操作系统那里挖的，基本上是用多少挖多少，直 挖到maxMemory()为止，所以totalMemory()是慢慢增大的。如果用了-Xms参数，程序在启动的时候就会无条件的从操作系统中挖- Xms后面定义的内存数，然后在这些内存用的差不多的时候，再去挖
        long l2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //这个方法返回的是java虚拟机（这个进程）能构从操作系统那里挖到的最大的内存，以字节为单位，如果在运行java程序的时 候，没有添加-Xmx参数，那么就是64兆，也就是说maxMemory()返回的大约是64*1024*1024字节，这是java虚拟机默认情况下能 从操作系统那里挖到的最大的内存。如果添加了-Xmx参数，将以这个参数后面的值为准，例如java -cp ClassPath -Xmx512m ClassName，那么最大内存就是512*1024*0124字节
        long l3 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        //告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
        //Runtime.getRuntime().gc();
        //强制调用已经失去引用的对象的finalize方法
        //Runtime.getRuntime().runFinalization();


        IntSummaryStatistics intSummaryStatistics = userArrayList.stream().mapToInt(User::getAge).summaryStatistics();
        //intSummaryStatistics对象自动过滤null。
        double average = intSummaryStatistics.getAverage();
        long count = intSummaryStatistics.getCount();
        int max2 = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        long sum = intSummaryStatistics.getSum();

        log.info("collect ---> {}", collect);
        log.info("max ---> {}", max);
        log.info("max1 ---> {}", max1);
        log.info("collect1 ---> {}", collect1);
        log.info("collect2 ---> {}", collect2);
        log.info("collect3 ---> {}", collect3);
        log.info("collect4 ---> {}", collect4);
        log.info("Boolean ---> {}", b);
        log.info("max age user ---> {}", max3);
        log.info("CUP ---> {}", i);
        log.info("freeMemory ---> {}", l1);
        log.info("totalMemory ---> {}", l2);
        log.info("MaxMemory ---> {}", l3);
        log.info("findFrist ---> {}", first);
        log.info("count ---> {}", count1);
        log.info("groupByAge ---> {}", integerArrayListMap);
        log.info("collect6 ---> {}", collect6);
        log.info("collect7 ---> {}", collect7);
        log.info("collect8 ---> {}", collect8);

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        long l = System.currentTimeMillis();
        LocalDate now = LocalDate.now();
        LocalDate now1 = LocalDate.now(clock);
        LocalDate localDate = LocalDate.now().withDayOfMonth(1);
        LocalDate localDate1 = LocalDate.now().minusDays(1);
        LocalDate localDate2 = LocalDate.now().plusDays(1);
        LocalTime now2 = LocalTime.now();
        LocalTime localDateTime = LocalTime.now().withNano(0);
        LocalTime localTime = LocalTime.now().plusHours(1).withNano(0);
        LocalDateTime now3 = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneRules rules = zoneId.getRules();
        TimeZone zonedefault = TimeZone.getDefault();

        //时间戳转日期
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTimeFormat = dateTimeFormatter1.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(Clock.systemDefaultZone().millis()), ZoneId.systemDefault()));


        //java8日期格式化。
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String format = dateTimeFormatter.format(LocalDate.now());

      /*  DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println(formatter2.format(LocalDate.now()));*/

        log.info("当前时间为-->{}", now);
        log.info("当前时间为-->{}", now1);
        log.info("当前时间加一天-->{}", localDate2);
        log.info("每个月的1号-->{}", localDate);
        log.info("昨天的当前时刻-->{}", localDate1);
        log.info("当前时间为-->{}", now2);
        log.info("当前时间不显示毫秒为-->{}", localDateTime);
        log.info("当前时间加一小时为-->{}", localTime);
        log.info("当前时间为-->{}", now3);
        log.info("时区为-->{}", zoneId);
        log.info("rules-->{}", rules);
        log.info("时区为-->{}", zonedefault);
        log.info("millis-->{}", millis);
        log.info("millis-->{}", l);
        log.info("dateFormat-->{}", format);


        log.info("服务器错误-->{}", StateCode.FAIL);


        /*HashSet<String> collect1 = objects.stream().map(String::toUpperCase).collect(Collectors.toCollection(HashSet::new));
        ArrayList<String> collect2 = objects.stream().distinct().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        Map<String, List<String>> collect = objects.stream().distinct().map(String::toUpperCase).collect(Collectors.groupingBy(String::new));*/


        long userId = 12055;
        Long userId1 = 12055L;

        if (userId == userId1){
            System.out.println("1111111111111111111111111111111111111");
        } else {
            System.out.println("22222222222222222222222222222222222222");
        }


    }

}
