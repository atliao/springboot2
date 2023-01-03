package com.la.springboot.mapper;

import com.la.springboot.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author LA
 * @date 2022-10-13-14:10
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getById(Long id);

    @Insert("insert into city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id") //自增主键，回填id功能
    public void insert(City city);
}
