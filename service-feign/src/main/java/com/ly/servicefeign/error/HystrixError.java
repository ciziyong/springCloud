package com.ly.servicefeign.error;

import com.ly.servicefeign.ServiceHi;
import org.springframework.stereotype.Component;

@Component
public class HystrixError implements ServiceHi {
    @Override
    public String testHi(String name) {
        return "sorry,hystrix!" + name;
    }
}
