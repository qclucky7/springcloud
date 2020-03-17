package com.example.springcloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName test
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/13 15:33
 * @Version 1.0
 */
public class test {


    static <T> T findFirst(List<T> list) {

        Optional<T> first = list.stream().findFirst();


        return first.get();
    }

    static <T> long getCount(List<T> list) {


        return list.stream().count();
    }

    static <T extends User> Map<Integer, ArrayList<T>> groupingByAge(List<T> list){

        return list.stream().collect(Collectors.groupingBy(User::getAge, Collectors.toCollection(ArrayList::new)));

    }
}
