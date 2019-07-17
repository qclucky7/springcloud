package com.example.cloudfegin.feginclient;

import com.example.cloudfegin.fallback.HystrixClientTwoService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-client-two",fallback = HystrixClientTwoService.class)
public interface ClientTwoService {

    @GetMapping(value = "/client2/getData")
    String getData();

    @GetMapping(value = "/client2/getData2")
    String getData2();
}
