package com.example.feigncomsumer.controller;

import com.example.feigncomsumer.bean.User;
import com.example.feigncomsumer.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerFeignController {

    @Autowired
    HelloFeignService helloFeignService;


    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloService(){
       return  helloFeignService.feignDemo();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloService2(){

        StringBuilder  sb=new StringBuilder();
        sb.append(helloFeignService.feignDemo("李林"))
                .append(helloFeignService.feignDemo(new User("未知妻子","25")));
        return  sb.toString();
    }

}
