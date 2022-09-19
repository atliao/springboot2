package com.la.springboot.controller;

import com.la.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LA
 * @date 2022-09-14-20:08
 */
@RestController
public class PersonController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person getPerson(){
        System.out.println(person.getUserName());
        return person;
    }
}
