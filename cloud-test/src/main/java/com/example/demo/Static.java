package com.example.demo;


import com.example.demo.threadpoolexecutor.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.UsesJava7;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Static
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/10/15 16:17
 * @Version 1.0
 */
@Slf4j
public class Static implements compulte {


    //static int sum = 20;
    //static int sign = 0;

    static class User{

        private String name;

        private List<Job> job;


        public User(@NonNull String name, List<Job> job) {
            this.name = name;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Job> getJob() {
            return job;
        }

        public void setJob(List<Job> job) {
            this.job = job;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", job=" + job +
                    '}';
        }
    }

    static class Job{

        private long number;

        @NotBlank(message = "不能为空")
        private String space;

        public Job(@Max(value = 10,message = "error") long number, @NotBlank(message = "不能为空") String space) {
            this.number = number;
            this.space = space;
        }

        public long getNumber() {
            return number;
        }

        public void setNumber(long number) {
            this.number = number;
        }

        public String getSpace() {
            return space;
        }

        public void setSpace(String space) {
            this.space = space;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "number=" + number +
                    ", space='" + space + '\'' +
                    '}';
        }
    }


    static class Outer {
        Nested nested;

        public Outer(Nested nested) {
            this.nested = nested;
        }

        public Nested getNested() {
            return nested;
        }

        public void setNested(Nested nested) {
            this.nested = nested;
        }

        @Override
        public String toString() {
            return "Outer{" +
                    "nested=" + nested +
                    '}';
        }
    }

    static class Nested {
        Inner inner;

        public Nested(Inner inner) {
            this.inner = inner;
        }

        public Inner getInner() {
            return inner;
        }

        public void setInner(Inner inner) {
            this.inner = inner;
        }

        @Override
        public String toString() {
            return "Nested{" +
                    "inner=" + inner +
                    '}';
        }
    }

    static class Inner {


        String foo;

        public Inner(String foo) {
            this.foo = foo;
        }

        public String getFoo() {
            return foo;
        }

        public void setFoo(String foo) {
            this.foo = foo;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "foo='" + foo + '\'' +
                    '}';
        }
    }

    private static long compulte (long number){
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number+100;
    }

    public void test(){

        this.test1();
    }


    public static CompletableFuture<String> test(@Valid Job job){

        System.out.println(job);

        return CompletableFuture.completedFuture("123");
    }



    public static void main(String[] args) {


        test(new Job(10, null));
        Job job1 = new Job(0, null);
        job1.setSpace(null);
        job1.setNumber(1);


        List<User> list = new ArrayList<>();

        Map<String,List<List<User>>> map = new HashMap<>();


        CompletableFuture.supplyAsync(() -> list.stream()
                .flatMap(y -> y.job.stream())
                .filter(job -> job.number > 10L)
                .peek(p -> p.setSpace(null))
                .collect(Collectors.toList())
        ).thenApply(result ->
                result.stream()
                        .findAny()
                        .orElse(new Job(1L, "456"))
        );

        map.forEach((k,v) -> {

            CompletableFuture.supplyAsync(() -> v.stream()
                    .flatMap(Collection::stream)
                    .flatMap(y -> y.job.stream())
                    .filter(job -> job.number > 10L)
                    .peek(p -> p.setSpace(null))
                    .collect(Collectors.toList())
            ).thenCompose(result ->
                    CompletableFuture.completedFuture(result.stream()
                            .findAny()
                            .orElse(new Job(1L, "456"))
                    )
            );


            CompletableFuture<Job> jobCompletableFuture = CompletableFuture.supplyAsync(() -> v.stream()
                    .flatMap(Collection::stream)
                    .flatMap(y -> y.job.stream())
                    .filter(job -> job.number > 10L)
                    .peek(p -> p.setNumber(p.number + 1))
                    .collect(Collectors.toList())
            ).thenApply(result ->
                    result.stream()
                            .findAny()
                            .orElse(new Job(1L, "456"))
            );


            CompletableFuture<CompletableFuture<String>> completableFutureCompletableFuture = jobCompletableFuture.thenApply(Static::test);
            CompletableFuture<String> stringCompletableFuture = jobCompletableFuture.thenCompose(Static::test);

        });

        Stream.iterate(0,n -> n+1).limit(5).forEach( n -> {
            Job job = new Job(n,"job"+ n);
            List<Job> objects = new ArrayList<>();
            objects.add(job);
            User user = new User(String.valueOf(n),objects);
            list.add(user);
        });

        System.out.println(list.toString());


        List<Job> collect = list.stream()
                .flatMap(user -> user.job.stream())
                .peek(p -> p.setNumber(p.number + 1))
                .collect(Collectors.toList());

        LongSummaryStatistics longSummaryStatistics = list.stream()
                .flatMap(user -> user.job.stream())
                .mapToLong(Job::getNumber)
                .summaryStatistics();
        long sum = list.stream().flatMap(user -> user.job.stream()).mapToLong(Job::getNumber).sum();

        List<Long> l = new ArrayList<>();
        List<Boolean> collect1 = list.stream()
                .flatMap(user -> user.job.stream())
                .mapToLong(Job::getNumber)
                .mapToObj(l::add)
                .collect(Collectors.toList());


        System.out.println(l);
        System.out.println(collect1);

        System.out.println(collect);
        System.out.println(sum);



        //Map<String, Long> collect2 = list.stream().flatMap(user -> user.job.stream()).collect(Collectors.toMap(Job::getSpace, job -> compulte(job.number)));

        //System.out.println("values = " + collect2.values());


        //System.out.println(collect2);




        List<Outer> list1 = new ArrayList<>();

        list1.add(new Outer(new Nested(new Inner("123"))));

        System.out.println(list1);

        Inner inner = Optional.ofNullable(list1.get(0))
                .flatMap(outer -> Optional.ofNullable(outer.nested)
                .flatMap(nested -> Optional.ofNullable(nested.inner)))
                .orElse(new Inner("456"));

        System.out.println(inner);


        String[] strings = {"abc","abcd....","1"};

        String s = Arrays.stream(strings).reduce((x, y) -> x.length() > y.length() ? x : y).orElse(" ");
        System.out.println(s);


        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(9);
        nums.add(7);
        nums.add(5);

        nums.parallelStream().reduce(0, (sum1,num) -> sum1 + num, (result1 , result2) -> result1 + result2 );


       /* Stream.iterate(Clock.systemDefaultZone().millis(), n -> n = n + 1).forEach(x ->
        {
            System.out.println(x);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });*/

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        CountDownLatch latch = new CountDownLatch(1);
        //阻塞队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        BlockingQueue<Method> queue1 = new LinkedBlockingQueue<>(5);

        Queue<Delayed> delayeds = new DelayQueue<>();


        /*new Thread(()->{
            Stream.iterate(0, n-> n+1).limit(5).forEach(x-> {
                try {
                    queue.put(String.valueOf(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
            System.out.println("[queue]的值before = " + queue);
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
                Stream.iterate(0, n -> n + 1 ).limit(2).forEach(x->{
                    try {
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[queue]的值now = " + queue);
        }).start();

        List<Future<Long>> futures = new ArrayList<>();
        try {
            for (int i = 0; i < 5  ; i++) {
                final int i1 = i;
                Future<Long> longCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    long compulte = compulte(i1);
                    return compulte;
                }, ThreadPoolFactory.getPoolExecutor());

                System.out.println(longCompletableFuture.toString());
                System.out.println(longCompletableFuture.isDone());
                System.out.println(longCompletableFuture.isCancelled());
                //longCompletableFuture.get(500, TimeUnit.MILLISECONDS);
                futures.add(longCompletableFuture);
            }

        } catch (Exception ex){
           log.info("error",ex);
        }

        for (int i = 0; i < 2 ; i++) {
            Iterator<Future<Long>> iterator = futures.iterator();
            while (iterator.hasNext()){
                Future<Long> next = iterator.next();
                try {
                    next.get(500,TimeUnit.MILLISECONDS);
                    System.out.println(futures);
                    iterator.remove();
                } catch (InterruptedException ex) {
                    break;
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                    iterator.remove();
                } catch (TimeoutException ex) {
                    log.info("TimeoutException",ex);
                    continue;
                }
            }
        }
        System.out.println(futures.toString());
        // 将三次都失败的, cancel
        for (Future<Long> future : futures) {
            future.cancel(true);
            futures.remove(future);
        }
        System.out.println(futures.toString());*/



        System.out.println("Retrieving weight.");
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 65.0;
        });

        System.out.println("Retrieving height.");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 177.8;
        });

        System.out.println("Calculating BMI.");
        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                });

        try {
            System.out.println("Your BMI is - " + combinedFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

            CompletableFuture<Job> jobCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
                List<Job> jobs = new ArrayList<>();
                jobs.add(new Job(1L, "123"));
                return jobs;
            }).thenCompose(jobs ->
                    jobs.stream()
                            .peek(job -> job.setNumber(55555L))
                            .findAny()
                            .map(CompletableFuture::completedFuture)
                            .orElse(AsyncUtils.newFailedFuture(new IllegalStateException("not a server: "))));



        CompletableFuture<Long> a = CompletableFuture.supplyAsync(()->compulte(10L));
        CompletableFuture<Long> b = CompletableFuture.supplyAsync(()->compulte(10L));
        CompletableFuture ex = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("runtime");
        });

        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture future = CompletableFuture.allOf(a,b,ex);
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture exFuture = future.exceptionally( exp -> {
            return ((RuntimeException) exp).getMessage();
        });
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        try {
            System.out.println(exFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());

        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "test ";
        }//,ThreadPoolFactory.getPoolExecutor()
        ).thenApply(u -> {
            try {
                throw new MyException(ErrorCode.expires,null);
            } catch (MyException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return u + "in thenApply first";
        }).thenCompose(u -> CompletableFuture.supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName());
                            return u + "in thenCompose second";
                        })
         ).exceptionally(e -> {
             if (e instanceof MyException){
                log.info("message = {}",e.getMessage());
             }
             return String.valueOf(e);
        });




       /* try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


       /* String[] arrayOfWords = {"Java", "Magazine"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        System.out.println(streamOfwords);*/

        //Stream.of("l12", "a222", "a3")
                //.map(s -> s.substring(1)) // 对每个字符串元素从下标1位置开始截取
                //.mapToInt(Integer::parseInt) // 转成 int 基础类型类型流
                //.forEach(System.out::println);
                //.max() // 取最大值
                //.ifPresent(System.out::println);  // 不为空则输出

        //IntStream.range(1, 4)
                //.mapToObj(i -> "a" + i) // for 循环 1->4, 拼接前缀 a
                //.forEach(System.out::println); // for 循环打印

        //Stream.of(1.0, 2.0, 3.0)
                //.mapToInt(Double::intValue) // double 类型转 int
                //.mapToObj(i -> "a" + i) // 对值拼接前缀 a
                //.forEach(System.out::println); // for 循环打印

        /*//循环标签
        retry:
        for (;;){
            for (int i = 0 ; i < 100; i++){
                System.out.println(i);
                if (i == 50){
                    break retry;
                }
            }
        }*/



        /*int CAPACITY   = (1 << Integer.SIZE - 3) - 1;


        System.out.println(CAPACITY);*/


        //System.out.println(Optional.ofNullable(null).orElseThrow(NullPointerException::new));

        //System.out.println(Optional.of(null).orElse(1));






        /*String s = Long.toHexString(18);

        final int i = 1 << 10;

        System.out.println(i);

        Random random = new Random();

        System.out.println(random.nextInt(10));


        System.out.println(Math.sqrt(10));



        Map<String, HashSet<String>> map1 = new HashMap<>();
        map1.computeIfAbsent("fruits", k -> new HashSet<>()).add("apple");
        map1.computeIfAbsent("fruits", k -> new HashSet<>()).add("orange");
        map1.computeIfAbsent("fruits", k -> new HashSet<>()).add("pear");
        map1.computeIfAbsent("meat", k -> new HashSet<>()).add("beef");
        map1.computeIfAbsent("meat", k -> new HashSet<>()).add("fish");
        System.out.println(map1);



        Map<String, Integer> wordCounts = new ConcurrentHashMap<>(10);
        String s1 =
                "Lorem ipsum dolor sit amet consetetur iam nonumy sadipscing " +
                        " elitr, sed diam nonumy eirmod tempor invidunt ut erat sed " +
                        "labore et dolore magna dolor sit amet aliquyam erat sed diam";

        wordCounts.put("sed", 0);
        for (String t : s1.split(" ")) {
            wordCounts.compute(t, (k, v) ->{
                if(null == v) v = 0;
                v= v + 1;
                return v;
            });
        }
        System.out.println(wordCounts);*/



        /*ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() +"----"+UUID.randomUUID().toString());
            });
        }

        final String s = "123" + UUID.randomUUID().toString();*/

/*
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

        System.out.println(TimeUnit.SECONDS);*/

    }
}
