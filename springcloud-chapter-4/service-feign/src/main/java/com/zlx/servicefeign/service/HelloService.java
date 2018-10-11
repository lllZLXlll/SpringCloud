package com.zlx.servicefeign.service;

import com.zlx.servicefeign.service.fallback.HelloServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 指定服务名，调用服务，指定断路器失败回调
@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceFallBack.class)
public interface HelloService {

    @GetMapping("/hi")
    String sayHelloClient(@RequestParam("name") String name);
}
