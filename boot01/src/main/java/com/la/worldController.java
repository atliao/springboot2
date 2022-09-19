package com.la;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LA
 * @date 2022-09-12-15:15
 */
@RestController
public class worldController {

    @RequestMapping("/world")
    public String world(){
        return "hello world!";
    }
}
