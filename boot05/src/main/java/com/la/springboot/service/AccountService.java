package com.la.springboot.service;

import com.la.springboot.bean.Account;
import com.la.springboot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LA
 * @date 2022-10-13-12:46
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Integer id){
        return accountMapper.getAcctById(id);
    }
}
