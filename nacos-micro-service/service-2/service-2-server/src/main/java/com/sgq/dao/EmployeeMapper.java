package com.sgq.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.Employee;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface EmployeeMapper extends BaseMapper<Employee> {

    Employee selectById(@Param("id") Integer id);

    List<Employee> selectByLike(@Param("name") String name);



}
