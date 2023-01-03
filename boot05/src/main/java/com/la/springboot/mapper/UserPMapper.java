package com.la.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.la.springboot.bean.UserP;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LA
 * @date 2022-10-14-17:26
 */
@Mapper
public interface UserPMapper extends BaseMapper<UserP> {//继承BaseMapper,不用写xml文件
}
