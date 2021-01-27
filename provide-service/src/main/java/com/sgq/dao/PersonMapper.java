package com.sgq.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface PersonMapper extends BaseMapper<Person> {

    @Select("select * from person")
    List<Person> selectAll();

    @Select("select * from person where id = #{id}")
    Person selectById(@Param("id") Integer id);

    int deleteById(List<Integer> idList);
}
