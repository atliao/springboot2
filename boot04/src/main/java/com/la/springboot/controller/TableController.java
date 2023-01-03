package com.la.springboot.controller;

import com.la.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author LA
 * @date 2022-09-20-15:28
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表单内容动态遍历
        List<User> users = Arrays.asList(new User("张三", "123456"),
                new User("李四", "666888"),
                new User("王五", "555555"),
                new User("赵六", "111111"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        int i = 1/0;
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }
}
