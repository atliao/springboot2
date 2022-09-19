package com.la.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LA
 * @date 2022-09-19-16:27
 */
@Controller
public class ViewController {

    @RequestMapping("/la")
    public String laSuccess(Model model){
        model.addAttribute("note","page created by LA!");
        model.addAttribute("link","/");
        return "success";
    }
}
