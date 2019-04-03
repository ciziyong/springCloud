package com.ly.servicehi.sysUser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class SysUserController {
    @Value("${server.port}")
    private String port;

    /* @Value("${foo}")
     String foo;*/
    @RequestMapping(value = "/hi")
    public String hi(String name) {
        return "hi" + name + " ,i am from port:" + "," + port;
    }
}
