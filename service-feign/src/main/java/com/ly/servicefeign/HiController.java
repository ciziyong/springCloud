package com.ly.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    ServiceHi serviceHi;

    @RequestMapping(value = "/hi")
    public String testHi(@RequestParam String name) {
        return serviceHi.testHi(name);
    }
}
