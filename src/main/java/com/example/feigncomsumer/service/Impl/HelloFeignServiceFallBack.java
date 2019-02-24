package com.example.feigncomsumer.service.Impl;

import com.example.feigncomsumer.bean.User;
import com.example.feigncomsumer.service.HelloFeignService;
import org.springframework.stereotype.Component;


/**
 * feigin可以实现服务的降级  就是编写一个实现类 并在@FeignClient中指定这个实现类  就是服务降级调用
 */
@Component
public class HelloFeignServiceFallBack implements HelloFeignService {
    @Override
    public String feignDemo() {
        return "error";
    }

    @Override
    public String feignDemo(String name) {
        return "error";
    }

    @Override
    public String feignDemo(User user) {
        return "error";
    }
}
