package com.example.account.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: com.example.account.utils-> Md5TokenGenerator
 * @description:
 * @author: tfJin
 * @createDate: 2020-12-30 14:20
 * @version: 1.0
 * @todo:
 */
@Component
public class Md5TokenGenerator {
    final Map<String,String> redisUtils = new HashMap<>();

    /**
     * token生成器
     * @param strings 参数可以多个
     * @return token token->(s1+s2...+时间戳)MD5加密
     */

    public String generate(String... strings) {
        long timeStamp = System.currentTimeMillis();//获取当前时间戳
        StringBuilder tokenMeta = new StringBuilder();
        for (String s: strings){//整合所有字符串参数为一个
            tokenMeta.append(s);
        }
        tokenMeta.append(timeStamp);//加入时间戳
        return  DigestUtils.md5DigestAsHex(tokenMeta.toString().getBytes());//MD5加密
    }

    /**
     * token存入redis缓存
     * @param username  用户名
     * @param password  密码
     * @return token(username+password+时间戳)MD5加密
     */
    public String tokenUtils(String username, String password){
        //设置token
        String token = generate(username,password);
        redisUtils.put(username,token);//五分钟失效缓存
        redisUtils.put(token,username);
        redisUtils.put(username+token,"1000");//设置第一次登陆的时间为token的初始时间
        return token;
    }

    public Boolean checkToken(String token) {
       return redisUtils.get(token)!=null ? true : false;
    }
}
