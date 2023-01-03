package com.la.springboot.service;

import com.la.springboot.bean.Account;
import com.la.springboot.mapper.AcctMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LA
 * @date 2022-10-13-12:46
 */
@Service
public class AcctService {

    @Autowired
    AcctMapper acctMapper;

    public Account getAcctById(Integer id){
        return acctMapper.getAcctById(id);
    }
}
