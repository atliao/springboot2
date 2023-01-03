package com.la.springboot.controller;

import com.la.springboot.bean.Account;
import com.la.springboot.bean.City;
import com.la.springboot.service.AccountService;
import com.la.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LA
 * @date 2022-10-13-14:13
 */
@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/city")
    public City getById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public String saveCity(City city){
        cityService.saveCity(city);
        return "已保存：" + city;
    }
}
