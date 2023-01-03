package com.la.springboot.mapper;

import com.la.springboot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LA
 * @date 2022-10-13-12:43
 */
@Mapper
public interface AccountMapper {

    public Account getAcctById(Integer id);
}
