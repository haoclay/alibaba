package com.sgq.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.Animal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AnimalMapper extends BaseMapper<Animal> {

    @Select("select * from animal where 1=1")
    List<Animal> selectAll();


    List<Animal> selectLikePlus(Map map);



}
