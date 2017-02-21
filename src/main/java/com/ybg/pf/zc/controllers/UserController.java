package com.ybg.pf.zc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ybg on 17-2-17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(String name){
        log.info("call hello");
        return "hello " + name;
    }

    @RequestMapping("/login")
    public String login() {
        String url = "http://120.76.74.2:2100/userAccount/user/login?id=78";
        String result = restTemplate.getForObject(url, String.class);
        log.info("login result: " + result);
        return result;
    }
}
