package com.example.cloudfegin;

import org.springframework.stereotype.Component;

/**
 * @ClassName TestFallbackFactory
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/15 10:22
 * @Version 1.0
 */

@Component
public class TestService implements service {

    @Override
    public String test() { return "请求失败"+test().getClass().getName(); }

    @Override
    public String test2() { return "请求失败"+test2().getClass().getName(); }
}
