package com.la.springboot.service;

import com.la.springboot.bean.City;
import com.la.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LA
 * @date 2022-10-13-14:15
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city){
        cityMapper.insert(city);
    }
}
