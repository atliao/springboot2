package com.la.springboot.controller;

import com.la.springboot.bean.Account;
import com.la.springboot.service.AcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LA
 * @date 2022-10-13-12:48
 */
@Controller
public class AcctController {

    @Autowired
    AcctService acctService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getAcctById(@RequestParam("id") Integer id){
        return acctService.getAcctById(id);
    }
}
