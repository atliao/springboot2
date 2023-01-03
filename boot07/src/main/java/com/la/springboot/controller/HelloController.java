package com.la.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LA
 * @date 2022-11-19-13:42
 */
@Controller
public class HelloController {

    @Value("${person.name:未知}")
    String name;

    @ResponseBody
    @GetMapping("/")
    public String hello(){
        return "hello " + name;
    }
}
