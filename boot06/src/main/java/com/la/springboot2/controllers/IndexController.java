package com.la.springboot2.controllers;

import com.la.springboot2.actuator.service.Impl.IndexServiceImpl;
import com.la.springboot2.actuator.service.IndexService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LA
 * @date 2022-11-16-17:04
 */
@Controller
public class IndexController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    IndexService indexService;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @ResponseBody
    @GetMapping("/success")
    public String data(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String user = operations.get("user");
        System.out.println(user);
        showMsg();
        return user;
    }

    @ResponseBody
    @GetMapping("/show")
    public void showMsg(){
        indexService.show();
    }
}
