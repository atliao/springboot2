package com.la.springboot.mapper;

import com.la.springboot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LA
 * @date 2022-10-14-16:03
 */
@Mapper
public interface AcctMapper {
    public Account getAcctById(Integer id);
}
