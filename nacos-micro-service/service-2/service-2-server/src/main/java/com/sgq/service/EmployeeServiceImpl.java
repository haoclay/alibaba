package com.sgq.service;

import com.sgq.api.IEmployeeService;
import com.sgq.dao.EmployeeMapper;
import com.sgq.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.apache.dubbo.config.annotation.Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee findById(@Param("id") Integer id) {
        return employeeMapper.selectById(id);
    }


    public List<Employee> findByLike(@Param("name")String name) {
        return employeeMapper.selectByLike(name);
    }


    public  List<Employee> findByManyProperties(@Param("name")String name,
                                                @Param("email") String email){
        Map map = new HashMap(){{
            put("last_name",name);
            put("email",email);
        }};

      return  employeeMapper.selectByMap(map);
    }


}
