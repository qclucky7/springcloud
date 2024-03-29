package com.example.cloudfegin.fallback;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.cloudfegin.feginclient.ClientTwoService;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestFallbackFactory
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/15 10:22
 * @Version 1.0
 */

@Component
public class HystrixClientTwoService implements ClientTwoService {

    @Override
    public String getData() { return "请求失败"; }


    @Override
    public String getData2() { return "请求失败"; }
}
