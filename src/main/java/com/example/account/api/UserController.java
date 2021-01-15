package com.example.account.api;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.account.client.GatewayService;
import com.example.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: com.example.user.controller-> UserController
 * @description: 用户控制器
 * @author: tfJin
 * @createDate: 2020-12-09 10:06
 * @version: 1.0
 * @todo:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @NacosValue(value = "${nacos.test.propertie:1}", autoRefreshed = true)
    private String applicationName;
    @Autowired
    GatewayService gatewayService;
    @Autowired

    UserService userService;
    @GetMapping("/getUser")
    public String getUser() {
        log.info("TEST");
        return applicationName;
    }
    @GetMapping("/client")
    public String client() {
         Object test = gatewayService.test();
        return "user";
    }
    @GetMapping("/login")
    public String getUser(@RequestParam("username")String username,
                          @RequestParam("password") String password) {

        return userService.login(username,password);
    }

}
