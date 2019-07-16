package com.example.cloudfegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-client-one",fallback = TestService.class)
public interface service {

    @GetMapping(value = "/test1/test")
    String test();

    @GetMapping(value = "/test1/test2")
    String test2();
}
