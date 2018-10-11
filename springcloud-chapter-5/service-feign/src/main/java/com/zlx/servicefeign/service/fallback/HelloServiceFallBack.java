package com.zlx.servicefeign.service.fallback;


import com.zlx.servicefeign.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * 断路器回调类必须实现被断路类
 * 类中实现的方法就是接口中需要被断路的方法调用失败时的回调
 */
// 一定要注入到容器中
@Component
public class HelloServiceFallBack implements HelloService {

    @Override
    public String sayHelloClient(String name) {
        return "sorry "+name;
    }
}
