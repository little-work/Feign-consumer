package com.example.feigncomsumer.service;

import com.example.feigncomsumer.bean.User;
import com.example.feigncomsumer.service.Impl.HelloFeignServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = HelloFeignServiceFallBack.class)
public interface HelloFeignService {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String feignDemo();


    /**
     * @RequestParam注解在springMVC中  不指定value的话  会有一个默认值  但是在feign中必须指定value
     * 否则会报错
     * @param name
     * @return
     */
    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    String feignDemo(@RequestParam(value = "name") String name);

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    String feignDemo(@RequestBody User user);


}


