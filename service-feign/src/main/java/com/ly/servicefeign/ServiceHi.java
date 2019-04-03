package com.ly.servicefeign;

import com.ly.servicefeign.error.HystrixError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * service-hi 服务接口
 */
@FeignClient(value = "service-hi", fallback = HystrixError.class)
public interface ServiceHi {
    @RequestMapping(value = "/user/hi")
    String testHi(@RequestParam(value = "name") String name);
}
