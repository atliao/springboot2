package com.la.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LA
 * @date 2022-09-18-15:07
 */
@RestController
public class HelloController {

    @RequestMapping("/1.jpg")
    public String Hello(){
        return "hello!";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GetOne";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "PostOne";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PutOne";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DeleteOne";
    }
}
