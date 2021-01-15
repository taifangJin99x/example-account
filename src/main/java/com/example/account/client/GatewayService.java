package com.example.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @className: com.example.account.client-> GatewayService
 * @description:
 * @author: tfJin
 * @createDate: 2020-12-22 17:15
 * @version: 1.0
 * @todo:
 */
@FeignClient(value = "gateway")
public interface GatewayService {
    @GetMapping("/test/test")
    String test();
}
