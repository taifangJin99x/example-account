package com.example.account.service;

import com.example.account.domian.User;
import com.example.account.utils.Md5TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: com.example.account.service-> UserService
 * @description:
 * @author: tfJin
 * @createDate: 2020-12-29 13:48
 * @version: 1.0
 * @todo:
 */
@Service
public class UserService {
    @Autowired Md5TokenGenerator md5TokenGenerator;
   static User user = new  User("admin","admin",true,true,true,true);



    public String login(String username, String password) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)){

            return md5TokenGenerator.tokenUtils(username, password);
        }
        return null;
    }

    public Boolean checkToken(String token) {
        return md5TokenGenerator.checkToken(token);

    }

    public String getUser() {
        return "user";
    }
}
