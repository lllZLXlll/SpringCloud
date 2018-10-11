package com.zlx.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // 断路器，在调用服务时发生错误，将会调用fallbackMethod参数
    // 指定的方法进行处理调用备用服务或者返回错误信息等，很好的避免了容器的线程阻塞。
    @HystrixCommand(fallbackMethod = "failBack")
    public String hi(String name) {
        // 会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
    }

    public String failBack(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
