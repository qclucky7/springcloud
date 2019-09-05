package com.example.demo;

import com.example.demo.designmodel.observer.impl.InFormerImpl;
import com.example.demo.designmodel.observer.observer.Observer1;
import com.example.demo.designmodel.observer.observer.Observer2;
import com.example.demo.test.TestAspectJ;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        TestAspectJ.test();


        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        InFormerImpl inFormer = new InFormerImpl();
        inFormer.add(observer1);
        inFormer.add(observer2);
        List<Object> change = inFormer.change();

        System.out.println(change);
    }


}
