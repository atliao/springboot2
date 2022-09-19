package com.la.springboot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LA
 * @date 2022-09-19-10:01
 */
@RestController
public class ParameterTestController {

    @RequestMapping("/car/{id}/user/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv, //获取所有占位符参数

                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header, //获取所有请求头信息

                                     @RequestParam("age") Integer age,
                                     @RequestParam("interests") List<String> interests,
                                     @RequestParam Map<String,String> rp,
                                     @CookieValue("Idea-aafc89f8") String idea,
                                     @CookieValue("Idea-aafc89f8") Cookie cookie) {

        Map<String,Object> map = new HashMap<>();

        //map.put("id",id);
        //map.put("username",username);
        //map.put("pv",pv);

        //map.put("userAgent",userAgent);
        //map.put("header",header);

        map.put("age",age);
        map.put("interests",interests);
        map.put("rp",rp);
        map.put("Idea-aafc89f8",idea);
        map.put("Cookie",cookie);

        return map;

    }

    @RequestMapping("/save")
    public Map<String,Object> getRequestBody(@RequestBody String requestBody, String username, String password, String content,
                                             @RequestParam("username") String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        map.put("username",username);
        map.put("password",password);
        map.put("requestBody",requestBody);
        map.put("name", name);
        return map;

    }

    //获取矩阵变量的值
    //1.语法：/cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认禁用了矩阵变量的功能，需要手动开启
        //关闭移除分号内容：remove
    //3.矩阵变量必须有url路径变量才能解析
    @RequestMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("path",path);
        map.put("low",low);
        map.put("brand",brand);
        return map;
    }

    //1.语法：/boss/1;age=20/2;age=10
            //前面老板信息，后面员工信息
    //2.SpringBoot默认禁用了矩阵变量的功能，需要手动开启
            //关闭移除分号内容：remove
    //3.矩阵变量必须有url路径变量才能解析
    @RequestMapping("/boss/{bossId}/{empId}")
    public Map getAge(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                        @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
