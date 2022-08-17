package com.sgq.service;


import com.sgq.dao.AnimalMapper;
import com.sgq.pojo.Animal;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalService implements IAnimalService {
    @Autowired
    private AnimalMapper dao;

    @Override
    public List<Animal> findAll() {
        return  dao.selectAll();
    }

    @Override
    public List<Animal> findByLike(String name, Integer age) {
        Map map = new HashMap(){{
            put("name",name);
            put("age",age);
        }};
        return dao.selectLikePlus(map);
    }

    @Override
    public List<Animal> findByLikeDefault(String name, Integer age) {
        Map map = new HashMap(){{
            put("name",name);
            put("age",age);
        }};
        return dao.selectByMap(map);
    }


}
