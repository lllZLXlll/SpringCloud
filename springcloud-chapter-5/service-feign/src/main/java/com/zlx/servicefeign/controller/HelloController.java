package com.zlx.servicefeign.controller;

import com.zlx.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    String sayHelloClient(@RequestParam("name") String name) {
        return helloService.sayHelloClient(name);
    }

}
