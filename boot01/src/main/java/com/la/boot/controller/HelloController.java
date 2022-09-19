package com.la.boot.controller;

import com.la.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LA
 * @date 2022-09-11-15:31
 */
//@Controller
//@ResponseBody

//spring boot中，controller必须放在和主程序相同的包下
//如果想要放在包外，需在主程序中设置路径
@RestController //包含 Controller 和 ResponseBody
@Slf4j
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    //@ResponseBody写在类上，全部方法适用
    public String hello(){
        return "Hello,Spring Boot2!";
    }

    @RequestMapping("/car")
    public Car car(){
        log.info("请求来了...");
        return car;
    }
}
