package com.zlx.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("EUREKA-CLIENT") // 指定服务名，调用服务
public interface HelloService {

    @GetMapping("/hi")
    String sayHelloClient(@RequestParam("name") String name);
}
