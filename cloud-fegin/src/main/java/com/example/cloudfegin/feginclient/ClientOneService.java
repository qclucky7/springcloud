package com.example.cloudfegin.feginclient;

import com.example.cloudfegin.fallback.HystrixClientOneService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-client-one",fallback = HystrixClientOneService.class)
public interface ClientOneService {

    @GetMapping(value = "/client1/getData")
    String getData();

    @GetMapping(value = "/client1/getData2")
    String getData2();
}
