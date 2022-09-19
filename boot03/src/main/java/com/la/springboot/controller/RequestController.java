package com.la.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LA
 * @date 2022-09-19-10:56
 */
@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        request.setAttribute("code", 200);
        return "forward:/success"; //转发到success请求
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code,
                          HttpServletRequest request){
        String msg1 = (String)request.getAttribute("msg");
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("msg1",msg1);
        map.put("code",code);
        return map;
    }
}
