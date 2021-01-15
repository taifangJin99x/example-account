package com.example.account.openapi;

import com.example.account.client.GatewayService;
import com.example.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: com.example.account.openapi-> UserController
 * @description:
 * @author: tfJin
 * @createDate: 2020-12-29 13:45
 * @version: 1.0
 * @todo:
 */
@RestController
@RequestMapping("/openapi")
public class UserOpenController {
    @Autowired
    GatewayService gatewayService;
    @Autowired
    UserService userService;


    @GetMapping("/checkToken")
    public Boolean checkToken(@RequestParam("token") String token) {

        return userService.checkToken(token);
    }
}
