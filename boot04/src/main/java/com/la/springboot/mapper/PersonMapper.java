package com.la.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.la.springboot.bean.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LA
 * @date 2022-10-14-15:39
 */

public interface PersonMapper extends BaseMapper<Person> { //继承BaseMapper,不用写xml文件

}
