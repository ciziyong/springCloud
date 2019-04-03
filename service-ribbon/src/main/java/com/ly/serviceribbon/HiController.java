package com.ly.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HiController {
    @Autowired
    RestTemplate restTemplate;

    public String errorMethod(String name) {
        return "hi," + name + "----server error";
    }

    @GetMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "errorMethod")
    public String hiService(String name) {

        return restTemplate.getForObject("http://SERVICE-HI/user/hi?name=" + name, String.class);
    }

    @GetMapping(value = "/hi2")
    @HystrixCommand(fallbackMethod = "errorMethod") //熔断错误提示方法 必须和当前方法 参数一样 否则报 404 找不的错误方法
    public String hiService2(String name) {
        return restTemplate.getForObject("http://CONFIG-CLIENT/hi", String.class);
    }

}
